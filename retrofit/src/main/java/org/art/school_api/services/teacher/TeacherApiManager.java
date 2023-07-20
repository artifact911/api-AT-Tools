package org.art.school_api.services.teacher;

import lombok.SneakyThrows;
import org.art.retrofit.setup.ServiceManager;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

import static org.art.retrofit.ResponseUtils.validateResponse;

@Lazy
@Component
public class TeacherApiManager extends ServiceManager {

    private TeacherApiService teacherApiService;

    @PostConstruct
    private void init() {
        teacherApiService = serviceBuilder.build(TeacherApiService.class);
    }

    @SneakyThrows
    public <T> List<T> getAllTeachers(int expectedCode, Class<T> clazz) {
        return getBodyList(validateResponse(teacherApiService.getAllTeachers(), expectedCode), clazz);
    }

    @SneakyThrows
    public <T> T getTeacherById(int teacherId, int expectedCode, Class<T> clazz) {
        return getBody(validateResponse(teacherApiService.getTeacherById(teacherId), expectedCode), clazz);
    }

    @SneakyThrows
    public <T> List<T> getTeachersByTechnology(Map<String, String> params, int expectedCode, Class<T> clazz) {
        return getBodyList(validateResponse(teacherApiService.getTeachersByTechnology(params), expectedCode), clazz);
    }
}
