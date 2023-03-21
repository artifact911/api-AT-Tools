package org.art.services.lessonclass;

import lombok.SneakyThrows;
import org.art.retrofit.setup.ServiceManager;

import java.util.List;

import static org.art.retrofit.ResponseUtils.validateResponse;

public class LessonClassApiManager extends ServiceManager {

    private final LessonClassApiService lessonClassApiService;

    public LessonClassApiManager() {
        this.lessonClassApiService = serviceBuilder.build(LessonClassApiService.class);
    }

    @SneakyThrows
    public <T> List<T> getAllClasses(int expectedCode, Class<T> clazz) {
        return getBodyList(validateResponse(lessonClassApiService.getAllClasses(), expectedCode), clazz);
    }
}
