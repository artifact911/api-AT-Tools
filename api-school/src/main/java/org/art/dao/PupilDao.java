package org.art.dao;

import org.art.model.Pupil;
import org.art.storage.EntityStorage;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PupilDao implements Dao<Integer, Pupil> {

    @Override
    public List<Pupil> getAll() {
        return EntityStorage.getCities().stream()
                .flatMap(city -> city.getSchools().stream())
                .flatMap(school -> school.getLessonClassList().stream())
                .flatMap(lessonClass -> lessonClass.getPupils().stream())
                .collect(Collectors.toList());
    }

    @Override
    public Pupil getById(Integer id) {
        return getAll().stream()
                       .filter(pupil -> id.equals(pupil.getIdPupil()))
                .findFirst().orElse(new Pupil());
    }
}
