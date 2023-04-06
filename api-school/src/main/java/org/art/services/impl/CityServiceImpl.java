package org.art.services.impl;

import org.art.dto.city.CreateCityReqBody;
import org.art.model.City;
import org.art.repositories.CityRepository;
import org.art.services.CityService;
import org.art.util.CreateNewCityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<City> getAllCities() {
        return cityRepository.getAll();
    }

    @Override
    public City getCityById(Integer id) {
        return cityRepository.getById(id);
    }

    @Override
    public boolean createCity(CreateCityReqBody body) {
        return cityRepository.create(CreateNewCityUtil.createNewCity(body));
    }
}
