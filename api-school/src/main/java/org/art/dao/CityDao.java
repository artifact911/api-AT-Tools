package org.art.dao;

import org.art.model.City;
import org.art.storage.EntityStorage;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CityDao implements Dao<Integer, City> {

    @Override
    public List<City> getAll() {
        return EntityStorage.getCities();
    }

    @Override
    public Optional<City> getById(Integer id) {
        return EntityStorage.getCities().stream()
                .filter(city -> id.equals(city.getCityId()))
                .findFirst();
    }

    @Override
    public boolean delete(City entity) {
        return getAll().remove(entity);
    }

    @Override
    public boolean update(City entity) {
        getById(entity.getCityId()).ifPresent(city -> getAll().remove(city));
        return getAll().add(entity);
    }

    @Override
    public boolean create(City entity) {
        return getAll().add(entity);
    }
}
