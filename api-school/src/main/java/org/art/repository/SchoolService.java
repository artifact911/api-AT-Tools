package org.art.repository;

import org.art.model.School;

import java.util.List;

public interface SchoolService {

    List<School> getSchools();

    School getSchool(int id);
}
