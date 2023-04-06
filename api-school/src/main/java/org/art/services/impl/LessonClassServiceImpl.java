package org.art.services.impl;

import org.art.dao.LessonClassDao;
import org.art.model.LessonClass;
import org.art.repositories.LessonClassRepository;
import org.art.services.LessonClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonClassServiceImpl implements LessonClassService {

    private final LessonClassDao lessonClassDao;
    private final LessonClassRepository lessonClassRepository;

    @Autowired
    public LessonClassServiceImpl(LessonClassDao lessonClassDao,
                                  LessonClassRepository lessonClassRepository) {
        this.lessonClassDao = lessonClassDao;
        this.lessonClassRepository = lessonClassRepository;
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
    public LessonClass getLessonClassById(Integer id) {
        return lessonClassRepository.getById(id);
    }
}
