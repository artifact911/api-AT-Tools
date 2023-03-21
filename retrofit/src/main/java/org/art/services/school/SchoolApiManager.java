package org.art.services.school;

import lombok.SneakyThrows;
import org.art.retrofit.setup.ServiceManager;

import java.util.List;

import static org.art.retrofit.ResponseUtils.validateResponse;

public class SchoolApiManager extends ServiceManager {

    private final SchoolApiService schoolApiService;

    public SchoolApiManager() {
        this.schoolApiService = serviceBuilder.build(SchoolApiService.class);
    }

    @SneakyThrows
    public <T> List<T> getAllSchools(int expectedCode, Class<T> clazz) {
        return getBodyList(validateResponse(schoolApiService.getAllSchools(), expectedCode), clazz);
    }
}
