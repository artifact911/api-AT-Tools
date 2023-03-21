package org.art.services.impl;

import org.art.dao.CityDao;
import org.art.model.City;
import org.art.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    private final CityDao cityDao;

    @Autowired
    public CityServiceImpl(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @Override
    public List<City> getAllCities() {
        return cityDao.getAll();
    }

    @Override
    public City getCityById(Integer id) {
        return cityDao.getById(id);
    }
}
