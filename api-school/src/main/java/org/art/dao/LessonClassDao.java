package org.art.dao;

import org.art.model.LessonClass;
import org.art.storage.EntityStorage;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class LessonClassDao implements Dao<Integer, LessonClass> {

    @Override
    public List<LessonClass> getAll() {
        List<LessonClass> list = new ArrayList<>();

        EntityStorage.getCities().stream()
                .flatMap(city -> city.getSchools().stream())
                .forEach(school -> list.addAll(school.getLessonClassList()));

        return list;
    }

    @Override
    public Optional<LessonClass> getById(Integer id) {
        return getAll().stream()
                .filter(clazz -> id.equals(clazz.getIdLessonClass()))
                .findFirst();
    }

    @Override
    public boolean delete(LessonClass entity) {
        return false;
    }

    @Override
    public boolean update(LessonClass entity) {
        return false;
    }

    @Override
    public boolean create(LessonClass entity) {
        return false;
    }

    public List<LessonClass> getLessonClassesByLevel(Integer classLevel) {
        return getAll().stream()
                .filter(lc -> classLevel.equals(lc.getClazz()))
                .collect(Collectors.toList());
    }
}
