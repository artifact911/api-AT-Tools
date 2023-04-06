package org.art.repositories;

import org.art.dao.TeacherDao;
import org.art.exceptions.DaoException;
import org.art.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeacherRepository implements CrudRepository<Integer, Teacher> {

    private final TeacherDao teacherDao;

    @Autowired
    public TeacherRepository(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Override
    public List<Teacher> getAll() {
        return teacherDao.getAll();
    }

    @Override
    public Teacher getById(Integer id) {
        return teacherDao.getById(id).orElseThrow(() -> new DaoException("Teacher is not found"));
    }

    @Override
    public boolean delete(Teacher entity) {
        return false;
    }

    @Override
    public boolean update(Teacher entity) {
        return false;
    }

    @Override
    public boolean create(Teacher entity) {
        return false;
    }
}
