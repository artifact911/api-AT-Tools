package org.art.services.impl;

import org.art.dao.PupilDao;
import org.art.dto.PupilReqBody;
import org.art.dto.pupil.CreatePupilReqBody;
import org.art.exceptions.DaoException;
import org.art.model.LessonClass;
import org.art.model.Pupil;
import org.art.repositories.LessonClassRepository;
import org.art.repositories.PupilRepository;
import org.art.services.PupilService;
import org.art.util.CreateNewPupilUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.art.util.CreateNewPupilUtil.createNewPupil;

@Service
public class PupilServiceImpl implements PupilService {

    private final PupilDao pupilDao;
    private final PupilRepository pupilRepository;
    private final LessonClassServiceImpl lessonClassService;

    @Autowired
    public PupilServiceImpl(PupilDao pupilDao,
                            PupilRepository pupilRepository,
                            LessonClassServiceImpl lessonClassService) {
        this.pupilDao = pupilDao;
        this.pupilRepository = pupilRepository;
        this.lessonClassService = lessonClassService;
    }

    @Override
    public List<Pupil> getAll() {
        return pupilRepository.getAll();
    }

    @Override
    public Pupil getPupilById(Integer id) {
        return pupilRepository.getById(id);
    }

    @Override
    public boolean delPupilById(Integer id) {
        return pupilDao.delPupilById(id);
    }

    @Override
    public boolean addPupilToSchool(Integer schoolId, PupilReqBody pupilReqBody) {
        return pupilDao.addPupil(schoolId, pupilReqBody);
    }

    @Override
    public boolean pathPupil(Integer pupilId, PupilReqBody pupilReqBody) {
        return pupilDao.patchPupil(pupilId, pupilReqBody);
    }

    @Override
    public boolean createPupil(CreatePupilReqBody body) {
        if (Objects.nonNull(body.getLessonClassId())) {
            LessonClass lessonClass = lessonClassService.getLessonClassById(body.getLessonClassId());

            Pupil newPupil = createNewPupil(body, lessonClass);
            pupilRepository.create(newPupil);
            return true;

        }
        return false;
    }
}
