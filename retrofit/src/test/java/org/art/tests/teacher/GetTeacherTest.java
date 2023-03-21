package org.art.tests.teacher;

import org.art.school.teacher.TeacherItem;
import org.art.services.teacher.TeacherApiManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

import static java.net.HttpURLConnection.HTTP_OK;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GetTeacherTest {

    private TeacherApiManager teacherApiManager;

    @BeforeAll
    void setUp() {
        teacherApiManager = new TeacherApiManager();
    }

    @Test
    public void getAllCities() {
        List<TeacherItem> allCities = teacherApiManager.getAllTeachers(HTTP_OK, TeacherItem.class);
    }
}
