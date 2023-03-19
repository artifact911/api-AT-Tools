package org.art.dao;

import org.art.model.Pupil;
import org.art.model.School;

import java.util.List;

public interface SchoolDao {

    List<School> getSchools();

    School getSchool(int id);

    List<Pupil> addPupil(int idSchool, Pupil pupil);

    List<Pupil> delPupil(int idSchool, int idPupil);
}
