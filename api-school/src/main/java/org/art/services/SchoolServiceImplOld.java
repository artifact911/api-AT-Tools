package org.art.services;

import org.art.dao.SchoolDaoOld;
import org.art.model.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolServiceImplOld implements SchoolServiceOld {

    private final SchoolDaoOld schoolDao;

    @Autowired
    public SchoolServiceImplOld(SchoolDaoOld schoolDao) {
        this.schoolDao = schoolDao;
    }

    @Override
    public List<School> getSchools() {
        return schoolDao.getSchools();
    }

    @Override
    public School getSchool(int id) {
        return schoolDao.getSchool(id);
    }
}
