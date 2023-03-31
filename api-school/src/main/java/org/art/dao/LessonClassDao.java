package org.art.dao;

import org.art.model.LessonClass;
import org.art.storage.EntityStorage;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class LessonClassDao implements Dao<String, LessonClass> {

    @Override
    public List<LessonClass> getAll() {
        List<LessonClass> list = new ArrayList<>();

        EntityStorage.getCities().stream()
                .flatMap(city -> city.getSchools().stream())
                .forEach(school -> list.addAll(school.getLessonClassList()));

        return list;
    }

    @Override
    public Optional<LessonClass> getById(String id) {
        return getAll().stream()
                .filter(clazz -> id.equals(clazz.getClassId()))
                .findFirst();
    }

    public List<LessonClass> getLessonClassesByLevel(Integer classLevel) {
        return getAll().stream()
                .filter(lc -> classLevel.equals(lc.getClazz()))
                .collect(Collectors.toList());
    }
}
