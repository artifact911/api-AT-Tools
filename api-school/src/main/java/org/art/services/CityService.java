package org.art.services;

import org.art.dto.city.CreateUpdateCityReqBody;
import org.art.model.City;

import java.util.List;

public interface CityService {

    List<City> getAllCities();
    City getCityById(Integer id);
    Integer createCity(CreateUpdateCityReqBody body);
    Integer patchCity(Integer cityId, CreateUpdateCityReqBody body);
    Integer putCity(Integer cityId, CreateUpdateCityReqBody body);
    boolean deleteCity(Integer id);
}
