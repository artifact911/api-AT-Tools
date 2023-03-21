package org.art.tests.teacher;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import org.art.AssertionsUtil;
import org.art.school.teacher.MainObject;
import org.art.school.teacher.TeacherItem;
import org.art.services.teacher.TeacherApiManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;
import java.util.Map;

import static java.net.HttpURLConnection.HTTP_OK;
import static org.art.ApiTags.TEACHER_API;
import static org.art.Teams.JOVE_TEAM;
import static org.art.Teams.KORBEN_TEAM;
import static org.art.TestTags.POSITIVE;
import static org.art.services.teacher.TeacherApiService.GET_ALL_TEACHERS_EP;
import static org.art.services.teacher.TeacherApiService.GET_CLASS_BY_TECHNOLOGY_EP;
import static org.art.services.teacher.TeacherApiService.GET_TEACHER_BY_ID_EP;
import static org.junit.jupiter.api.Assertions.assertFalse;

@Epic(TEACHER_API)
@Owner(KORBEN_TEAM)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GetTeacherTest {

    private TeacherApiManager teacherApiManager;
    private static final int TEACHER_ID = 9;

    @DisplayName("Подготовка тестовых данных")
    @BeforeAll
    void setUp() {
        teacherApiManager = new TeacherApiManager();
    }

    @TmsLink("TESTAM-8675")
    @Issue("AM-17059")
    @Owner(JOVE_TEAM)
    @Severity(SeverityLevel.BLOCKER)
    @Tags({@Tag(POSITIVE), @Tag(GET_ALL_TEACHERS_EP)})
    @Feature(GET_ALL_TEACHERS_EP)
    @DisplayName("Тест получения всех педагогов страны")
    @Test
    public void getAllTeachers() {
        List<TeacherItem> allTeachers = teacherApiManager.getAllTeachers(HTTP_OK, TeacherItem.class);

        assertFalse(allTeachers.isEmpty(), "Список преподавателей пуст");
    }

    @TmsLink("TESTAM-8675")
    @Issue("AM-17059")
    @Severity(SeverityLevel.NORMAL)
    @Tags({@Tag(POSITIVE), @Tag(GET_TEACHER_BY_ID_EP)})
    @Feature(GET_TEACHER_BY_ID_EP)
    @DisplayName("Тест получения педагога по id")
    @Test
    public void getTeacherById() {
        TeacherItem teacher = teacherApiManager.getTeacherById(TEACHER_ID, HTTP_OK, TeacherItem.class);
        AssertionsUtil.checkFieldValuesNotNull(teacher);
    }

    @TmsLink("TESTAM-8675")
    @Issue("AM-17059")
    @Severity(SeverityLevel.CRITICAL)
    @Tags({@Tag(POSITIVE), @Tag(GET_CLASS_BY_TECHNOLOGY_EP)})
    @Feature(GET_CLASS_BY_TECHNOLOGY_EP)
    @DisplayName("Тест получения преподавателей по профильным предметам")
    @Test
    public void getTeacherByTechnology() {
        List<TeacherItem> teachers = teacherApiManager
                .getTeachersByTechnology(Map.of("technology", MainObject.ASTRONOMY.name()), HTTP_OK, TeacherItem.class);

        assertFalse(teachers.isEmpty(), "Список преподавателей пуст");
    }
}
