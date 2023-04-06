package org.art.repositories;

import org.art.dao.LessonClassDao;
import org.art.model.LessonClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class LessonClassRepository implements CrudRepository<Integer, LessonClass> {

    private final LessonClassDao lessonClassDao;

    @Autowired
    public LessonClassRepository(LessonClassDao lessonClassDao) {
        this.lessonClassDao = lessonClassDao;
    }

    @Override
    public List<LessonClass> getAll() {
        return null;
    }

    @Override
    public Optional<LessonClass> getById(Integer id) {
        return lessonClassDao.getById(id);
    }

    @Override
    public boolean delete(LessonClass entity) {
        return false;
    }

    @Override
    public boolean update(LessonClass entity) {
        return false;
    }

    @Override
    public boolean create(LessonClass entity) {
        return false;
    }
}
