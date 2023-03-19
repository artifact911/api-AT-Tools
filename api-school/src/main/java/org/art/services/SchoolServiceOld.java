package org.art.services;

import org.art.model.School;

import java.util.List;

public interface SchoolServiceOld {

    List<School> getSchools();

    School getSchool(int id);
}
