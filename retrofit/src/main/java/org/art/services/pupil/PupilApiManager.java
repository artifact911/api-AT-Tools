package org.art.services.pupil;

import lombok.SneakyThrows;
import org.art.retrofit.setup.ServiceManager;

import java.util.List;

import static org.art.retrofit.ResponseUtils.validateResponse;

public class PupilApiManager extends ServiceManager {

    private final PupilApiService pupilApiService;

    public PupilApiManager() {
        this.pupilApiService = serviceBuilder.build(PupilApiService.class);
    }

    @SneakyThrows
    public <T> List<T> getAllPupils(int expectedCode, Class<T> clazz) {
        return getBodyList(validateResponse(pupilApiService.getAllPupils(), expectedCode), clazz);
    }
}
