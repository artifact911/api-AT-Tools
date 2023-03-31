package org.art.dao;

import org.art.model.MainObject;
import org.art.model.School;
import org.art.model.Teacher;
import org.art.storage.EntityStorage;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class TeacherDao implements Dao<Integer, Teacher> {

    @Override
    public List<Teacher> getAll() {
        List<Teacher> list = new ArrayList<>();

        EntityStorage.getCities().stream()
                .filter(city -> !city.getSchools().isEmpty())
                .flatMap(city -> city.getSchools().stream())
                .map(School::getTeacherList)
                .forEach(list::addAll);

        return list;
    }

    @Override
    public Optional<Teacher> getById(Integer id) {
        return getAll().stream()
                .filter(teacher -> id.equals(teacher.getTeacherId()))
                .findFirst();
    }

    public List<Teacher> getTeachersByTechnology(MainObject mainObject) {
        List<Teacher> list = getAll().stream()
                .filter(teacher -> mainObject.equals(teacher.getMainObject()))
                .collect(Collectors.toList());

        return list.isEmpty() ? new ArrayList<>() : list;
    }
}
