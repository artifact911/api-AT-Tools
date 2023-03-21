package org.art.services;

import org.art.model.Pupil;

import java.util.List;

public interface PupilService {

    List<Pupil> getAll();

    Pupil getPupilById(Integer id);

//    List<Pupil> postPupil(int idSchool, Pupil pupil);
//
//    Pupil editPupil(int idSchool, int idPupil, Pupil pupil);
//
//    List<Pupil> delPupil(int idSchool, int idPupil);
}
