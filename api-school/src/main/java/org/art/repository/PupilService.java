package org.art.repository;

import org.art.model.Pupil;

import java.util.List;

public interface PupilService {

    List<Pupil> getPupils(int idSchool);

    Pupil getPupil(int idSchool, int id);

    List<Pupil> postPupil(int idSchool, Pupil pupil);

    Pupil editPupil(int idSchool, int idPupil, Pupil pupil);

    List<Pupil> delPupil(int idSchool, int idPupil);

}
