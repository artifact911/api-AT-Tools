package org.art.school_api.services.lessonclass;

import lombok.SneakyThrows;
import org.art.retrofit.setup.ServiceManager;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

import static org.art.retrofit.ResponseUtils.validateResponse;

@Lazy
@Component
public class LessonClassApiManager extends ServiceManager {

    private LessonClassApiService lessonClassApiService;

    @PostConstruct
    private void init() {
        lessonClassApiService = serviceBuilder.build(LessonClassApiService.class);
    }

    @SneakyThrows
    public <T> List<T> getAllClasses(int expectedCode, Class<T> clazz) {
        return getBodyList(validateResponse(lessonClassApiService.getAllClasses(), expectedCode), clazz);
    }

    @SneakyThrows
    public <T> T getClassById(int classId, int expectedCode, Class<T> clazz) {
        return getBody(validateResponse(lessonClassApiService.getClassById(classId), expectedCode), clazz);
    }

    @SneakyThrows
    public <T> List<T> getClassByLevel(int classLevel, int expectedCode, Class<T> clazz) {
        return getBodyList(validateResponse(lessonClassApiService.getClassByLevel(classLevel), expectedCode), clazz);
    }
}
