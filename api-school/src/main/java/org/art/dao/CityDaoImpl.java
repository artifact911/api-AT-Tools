package org.art.dao;

import org.art.model.City;
import org.art.storage.EntityStorage;

import java.util.List;

public class CityDaoImpl implements Dao<Integer, City>{

    @Override
    public List<City> getAll() {
        return EntityStorage.getCities();
    }

    @Override
    public City getById(Integer id) {
        return EntityStorage.getCities().stream()
                .filter(city -> id.equals(city.getCityId())).findFirst().orElse(new City());
    }
}
