package org.art.services.city;

import lombok.SneakyThrows;
import org.art.retrofit.setup.ServiceManager;

import java.util.List;

import static org.art.retrofit.ResponseUtils.validateResponse;

public class CityApiManager extends ServiceManager {

    private final CityApiService cityApiService;

    public CityApiManager() {
        cityApiService = serviceBuilder.build(CityApiService.class);
    }

    @SneakyThrows
    public <T> List<T> getAllCities(int expectedCode, Class<T> clazz) {
       return getBodyList(validateResponse(cityApiService.getAllCities(), expectedCode), clazz);
    }
}
