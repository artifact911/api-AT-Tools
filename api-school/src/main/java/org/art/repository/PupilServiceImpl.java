package org.art.repository;

import org.art.dao.SchoolDao;
import org.art.model.Pupil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PupilServiceImpl implements PupilService {

    private final SchoolDao schoolDao;

    @Autowired
    public PupilServiceImpl(SchoolDao schoolDao) {
        this.schoolDao = schoolDao;
    }

    @Override
    public List<Pupil> getPupils(int idSchool) {
//        return schoolDao.getSchool(idSchool).getPupilList();
        return null;
    }

    @Override
    public Pupil getPupil(int idSchool, int id) {
//        return schoolDao.getSchool(idSchool).getPupilList().stream().filter(pupil -> pupil.getIdPupil() == id).findFirst().get();
        return null;
    }

    @Override
    public List<Pupil> postPupil(int idSchool, Pupil pupil) {
        schoolDao.addPupil(idSchool, pupil);
//        return schoolDao.getSchool(idSchool).getPupilList();
        return null;

    }

    @Override
    public Pupil editPupil(int idSchool, int idPupil, Pupil pupilNew) {
//        Pupil pupilEdited = schoolDao.getSchool(idSchool).getPupilList().stream()
//                                     .filter(pupil -> pupil.getIdPupil() == idPupil)
//                                     .findFirst().get();
//
//        pupilEdited.setFirstName(pupilNew.getFirstName());
//        pupilEdited.setLastName(pupilNew.getLastName());
//        pupilEdited.setClazz(pupilNew.getClazz());
//        pupilEdited.setPostfixClazz(pupilNew.getPostfixClazz());
//        return pupilEdited;
        return null;
    }

    @Override
    public List<Pupil> delPupil(int idSchool, int idPupil) {
//        schoolDao.delPupil(idSchool, idPupil);
//        return schoolDao.getSchool(idSchool).getPupilList();
        return null;
    }
}
