package org.art.dao;

import org.art.model.LessonClass;
import org.art.model.Pupil;
import org.art.storage.EntityStorage;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PupilDao implements Dao<Integer, Pupil> {

    static List<String> list1 = List.of("1", "2", "3", "4", "5");
    static List<String> list2 = new ArrayList<>(list1);

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

    public Optional<Pupil> getById() {
        Integer id = 100;

        return getAll().stream()
                .filter(pupil -> id.equals(pupil.getIdPupil()))
                .findFirst();
    }

    public boolean delPupilById(Integer id) {
        Optional<Pupil> foundUser = getById();

        if (foundUser.isPresent()) {
            EntityStorage.getCities().stream()
                    .flatMap(city -> city.getSchools().stream())
                    .flatMap(school -> school.getLessonClassList().stream())
                    .map(LessonClass::getPupils)
                    .forEach(lp -> lp.remove(foundUser.get()));
            return true;
        }
        return false;
    }
}
