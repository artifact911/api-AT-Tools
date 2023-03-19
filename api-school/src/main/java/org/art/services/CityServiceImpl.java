package org.art.services;

import org.art.dao.CityDaoImpl;
import org.art.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    CityDaoImpl cityDaoImpl;

    @Autowired
    public CityServiceImpl(CityDaoImpl cityDaoImpl) {
        this.cityDaoImpl = cityDaoImpl;
    }

    @Override
    public List<City> getAllCities() {
        return cityDaoImpl.getAll();
    }
}
