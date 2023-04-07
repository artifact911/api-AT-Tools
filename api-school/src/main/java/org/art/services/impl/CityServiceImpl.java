package org.art.services.impl;

import lombok.NonNull;
import org.art.dto.city.CreateUpdateCityReqBody;
import org.art.exceptions.DaoException;
import org.art.model.City;
import org.art.repositories.CityRepository;
import org.art.services.CityService;
import org.art.util.CreateNewCityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static java.util.Objects.nonNull;

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
    public Integer createCity(@NonNull CreateUpdateCityReqBody body) {
        City newCity = CreateNewCityUtil.createNewCity(body);
        if (cityRepository.create(newCity)) {
            return newCity.getCityId();
        }
        throw new DaoException("Create city error");
    }

    @Override
    public Integer patchCity(@NonNull Integer cityId, @NonNull CreateUpdateCityReqBody body) {
        City cityForPatch = getCityById(cityId);
        if (nonNull(body.getName())) cityForPatch.setName(body.getName());
        if (nonNull(body.getSchools())) cityForPatch.setSchools(body.getSchools());
        return cityForPatch.getCityId();
    }

    @Override
    public Integer putCity(@NonNull Integer cityId, @NonNull CreateUpdateCityReqBody body) {
        City cityForPut = getCityById(cityId);
        cityForPut.setName(body.getName());
        cityForPut.setSchools(body.getSchools());
        return cityForPut.getCityId();
    }

    @Override
    public boolean deleteCity(@NonNull Integer id) {
        return cityRepository.delete(getCityById(id));
    }
}
