package org.art.services;

import org.art.dto.city.CreateCityReqBody;
import org.art.model.City;

import java.util.List;

public interface CityService {

    List<City> getAllCities();
    City getCityById(Integer id);
    boolean createCity(CreateCityReqBody body);
}
