package org.art.services.impl;

import org.art.dao.LessonClassDao;
import org.art.model.LessonClass;
import org.art.services.LessonClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonClassServiceImpl implements LessonClassService {

    LessonClassDao lessonClassDao;

    @Autowired
    public LessonClassServiceImpl(LessonClassDao lessonClassDao) {
        this.lessonClassDao = lessonClassDao;
    }

    @Override
    public List<LessonClass> getAllLessonClasses() {
        return lessonClassDao.getAll();
    }

    @Override
    public List<LessonClass> getLessonClassesByLevel(Integer id) {
        return lessonClassDao.getLessonClassesByLevel(id);
    }

    @Override
    public LessonClass getLessonClassById(String id) {
        return lessonClassDao.getById(id);
    }
}