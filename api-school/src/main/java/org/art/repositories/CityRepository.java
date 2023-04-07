package org.art.repositories;

import org.art.dao.CityDao;
import org.art.exceptions.DaoException;
import org.art.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CityRepository implements CrudRepository<Integer, City> {

    private final CityDao cityDao;

    @Autowired
    public CityRepository(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @Override
    public List<City> getAll() {
        return cityDao.getAll();
    }

    @Override
    public City getById(Integer id) {
        return cityDao.getById(id).orElseThrow(() -> new DaoException("City is not found"));
    }

    @Override
    public boolean delete(City entity) {
        return cityDao.delete(getById(entity.getCityId()));
    }

    @Override
    public boolean update(City entity) {
        return cityDao.update(entity);
    }

    @Override
    public boolean create(City entity) {
        return cityDao.create(entity);
    }
}
