package org.art.dao;

import org.art.model.School;
import org.art.storage.EntityStorage;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SchoolDao implements Dao<Integer, School> {

    @Override
    public List<School> getAll() {
        List<School> list = new ArrayList<>();
        EntityStorage.getCities().stream()
                     .filter(city -> !city.getSchools().isEmpty())
                     .forEach(city -> list.addAll(city.getSchools()));

        return list;
    }

    @Override
    public School getById(Integer id) {
        return EntityStorage.getCities().stream()
                            .flatMap(city -> city.getSchools().stream())
                            .filter(school -> id.equals(school.getSchoolId()))
                            .findFirst()
                            .orElse(new School());
    }
}
