package org.art.repositories;

import org.art.dao.SchoolDao;
import org.art.exceptions.DaoException;
import org.art.model.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SchoolRepository implements CrudRepository<Integer, School> {

    private final SchoolDao schoolDao;

    @Autowired
    public SchoolRepository(SchoolDao schoolDao) {
        this.schoolDao = schoolDao;
    }

    @Override
    public List<School> getAll() {
        return schoolDao.getAll();
    }

    @Override
    public School getById(Integer id) {
        return schoolDao.getById(id).orElseThrow(() -> new DaoException("School is not found"));
    }

    @Override
    public boolean delete(School entity) {
        return false;
    }

    @Override
    public boolean update(School entity) {
        return false;
    }

    @Override
    public boolean create(School entity) {
        return false;
    }
}
