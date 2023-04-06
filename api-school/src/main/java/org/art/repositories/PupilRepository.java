package org.art.repositories;

import org.art.dao.PupilDao;
import org.art.model.Pupil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PupilRepository implements CrudRepository<Integer, Pupil> {

    private final PupilDao pupilDao;

    @Autowired
    public PupilRepository(PupilDao pupilDao) {
        this.pupilDao = pupilDao;
    }

    @Override
    public List<Pupil> getAll() {
        return pupilDao.getAll();
    }

    @Override
    public Optional<Pupil> getById(Integer id) {
        return pupilDao.getById(id);
    }

    @Override
    public boolean delete(Pupil entity) {
        return pupilDao.delete(entity);
    }

    @Override
    public boolean update(Pupil entity) {
        return pupilDao.update(entity);
    }

    @Override
    public boolean create(Pupil entity) {
        return pupilDao.create(entity);
    }
}
