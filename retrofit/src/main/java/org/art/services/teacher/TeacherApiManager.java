package org.art.services.teacher;

import lombok.SneakyThrows;
import org.art.retrofit.setup.ServiceManager;

import java.util.List;
import java.util.Map;

import static org.art.retrofit.ResponseUtils.validateResponse;

public class TeacherApiManager extends ServiceManager {

    private final TeacherApiService teacherApiService;

    public TeacherApiManager() {
        this.teacherApiService = serviceBuilder.build(TeacherApiService.class);
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
