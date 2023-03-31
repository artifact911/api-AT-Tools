package org.art.services.impl;

import org.art.dao.SchoolDao;
import org.art.model.School;
import org.art.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolServiceImpl implements SchoolService {

    private final SchoolDao schoolDao;

    @Autowired
    public SchoolServiceImpl(SchoolDao schoolDao) {
        this.schoolDao = schoolDao;
    }

    @Override
    public School getSchoolById(Integer id) {
        Optional<School> school = schoolDao.getById(id);
        return school.orElseGet(School::new);
    }

    @Override
    public List<School> getAll() {
        return schoolDao.getAll();
    }
}
