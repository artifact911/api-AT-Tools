package org.art.services;

import org.art.model.School;

import java.util.List;

public interface SchoolService {

    School getSchoolById(Integer id);
    List<School> getAll();
}
