package org.art.services;

import org.art.model.MainObject;
import org.art.model.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> getAll();
    List<Teacher> getTeachersByTechnology(String technology);
    Teacher getTeacherById(Integer id);
}
