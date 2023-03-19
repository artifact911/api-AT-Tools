package org.art.dao;

import org.art.model.Pupil;
import org.art.model.School;

import java.util.List;

public interface Dao<K, E> {

    List<E> getAll();

    E getById(K id);

//    List<Pupil> addPupil(int idSchool, Pupil pupil);
//
//    List<Pupil> delPupil(int idSchool, int idPupil);
}
