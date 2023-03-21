package org.art.services.impl;

import org.art.dao.PupilDao;
import org.art.model.Pupil;
import org.art.services.PupilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PupilServiceImpl implements PupilService {

    private final PupilDao pupilDao;

    @Autowired
    public PupilServiceImpl(PupilDao pupilDao) {
        this.pupilDao = pupilDao;
    }

    @Override
    public List<Pupil> getAll() {
        return pupilDao.getAll();
    }

    @Override
    public Pupil getPupilById(Integer id) {
        return pupilDao.getById(id);
    }
}
