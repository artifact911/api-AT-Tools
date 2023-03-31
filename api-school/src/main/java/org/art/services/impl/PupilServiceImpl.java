package org.art.services.impl;

import org.art.dao.PupilDao;
import org.art.dto.PupilReqBody;
import org.art.model.Pupil;
import org.art.services.PupilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<Pupil> pupil = pupilDao.getById(id);
        return pupil.orElseGet(Pupil::new);
    }

    @Override
    public boolean delPupilById(Integer id) {
        return pupilDao.delPupilById(id);
    }

    @Override
    public boolean addPupilToSchool(Integer schoolId, PupilReqBody pupilReqBody) {
        return pupilDao.addPupil(schoolId, pupilReqBody);
    }
}
