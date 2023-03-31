package org.art.services.impl;

import org.art.dao.TeacherDao;
import org.art.model.MainObject;
import org.art.model.Teacher;
import org.art.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherDao teacherDao;

    @Autowired
    public TeacherServiceImpl(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Override
    public List<Teacher> getAll() {
        return teacherDao.getAll();
    }

    @Override
    public List<Teacher> getTeachersByTechnology(String technology) {
        return teacherDao.getTeachersByTechnology(validateTechnology(technology));
    }

    @Override
    public Teacher getTeacherById(Integer id) {
        Optional<Teacher> teacher = teacherDao.getById(id);
        return teacher.orElseGet(Teacher::new);
    }

    private MainObject validateTechnology(String technology) {
        try {
            return MainObject.valueOf(technology);
        } catch (IllegalArgumentException e) {
            return MainObject.PHYSICS;
        }
    }
}
