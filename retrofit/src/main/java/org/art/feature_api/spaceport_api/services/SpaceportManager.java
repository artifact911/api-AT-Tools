package org.art.feature_api.spaceport_api.services;

import lombok.SneakyThrows;
import org.art.retrofit.setup.ServiceManager;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import static org.art.retrofit.ResponseUtils.validateResponse;

@Lazy
@Component
public class SpaceportManager extends ServiceManager {

    private SpaceportService spaceportService;

    @PostConstruct
    private void init() {
        spaceportService = serviceBuilder.build(SpaceportService.class);
    }

    @SneakyThrows
    public <T> T getAllSpaceport(String path, int statusCode, Class<T> clazz) {
        return getBody(validateResponse(spaceportService.getRequest(path), statusCode), clazz);
    }
}
