package org.art.school_api.services.city;

import lombok.SneakyThrows;
import org.art.retrofit.setup.ServiceManager;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

import static org.art.retrofit.ResponseUtils.validateResponse;

@Lazy
@Component
public class CityApiManager extends ServiceManager {

    private CityApiService cityApiService;

    @PostConstruct
    private void init() {
        cityApiService = serviceBuilder.build(CityApiService.class);
    }

    @SneakyThrows
    public <T> List<T> getAllCities(int expectedCode, Class<T> clazz) {
        return getBodyList(validateResponse(cityApiService.getAllCities(), expectedCode), clazz);
    }

    @SneakyThrows
    public <T> T getCityById(int cityId, int expectedCode, Class<T> clazz) {
        return getBody(validateResponse(cityApiService.getCityById(cityId), expectedCode), clazz);
    }
}
