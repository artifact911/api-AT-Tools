package org.art.services;

import org.art.model.LessonClass;

import java.util.List;

public interface LessonClassService {

    List<LessonClass> getAllLessonClasses();
    List<LessonClass> getLessonClassesByLevel(Integer id);
    LessonClass getLessonClassById(Integer id);
}
