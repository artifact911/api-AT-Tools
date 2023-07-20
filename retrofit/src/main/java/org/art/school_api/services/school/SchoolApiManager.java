package org.art.school_api.services.school;

import lombok.SneakyThrows;
import org.art.retrofit.setup.ServiceManager;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

import static org.art.retrofit.ResponseUtils.validateResponse;

@Lazy
@Component
public class SchoolApiManager extends ServiceManager {

    private SchoolApiService schoolApiService;

    @PostConstruct
    private void init() {
        schoolApiService = serviceBuilder.build(SchoolApiService.class);
    }

    @SneakyThrows
    public <T> List<T> getAllSchools(int expectedCode, Class<T> clazz) {
        return getBodyList(validateResponse(schoolApiService.getAllSchools(), expectedCode), clazz);
    }

    @SneakyThrows
    public <T> T getSchoolById(int schoolId, int expectedCode, Class<T> clazz) {
        return getBody(validateResponse(schoolApiService.getSchoolById(schoolId), expectedCode), clazz);
    }
}
