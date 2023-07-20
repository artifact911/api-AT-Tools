package org.art.school_api.services.pupil;

import lombok.SneakyThrows;
import org.art.retrofit.setup.ServiceManager;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

import static org.art.retrofit.ResponseUtils.validateResponse;

@Lazy
@Component
public class PupilApiManager extends ServiceManager {

    private PupilApiService pupilApiService;

    @PostConstruct
    private void init() {
        pupilApiService = serviceBuilder.build(PupilApiService.class);
    }

    @SneakyThrows
    public <T> List<T> getAllPupils(int expectedCode, Class<T> clazz) {
        return getBodyList(validateResponse(pupilApiService.getAllPupils(), expectedCode), clazz);
    }

    @SneakyThrows
    public <T> T getPupilById(int pupilId, int expectedCode, Class<T> clazz) {
        return getBody(validateResponse(pupilApiService.getPupilById(pupilId), expectedCode), clazz);
    }
}
