package org.art.school_api.lessonclass;

import io.qameta.allure.*;
import org.art.AssertionsUtil;
import org.art.RetrofitApplication;
import org.art.school.lessonclass.LessonClassItem;
import org.art.school_api.services.lessonclass.LessonClassApiManager;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static java.net.HttpURLConnection.HTTP_OK;
import static org.art.ApiTags.LESSON_CLASS_API;
import static org.art.Teams.CS2;
import static org.art.Teams.JOVE_TEAM;
import static org.art.TestTags.POSITIVE;
import static org.art.school_api.services.lessonclass.LessonClassApiService.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

@Epic(LESSON_CLASS_API)
@Owner(JOVE_TEAM)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(classes = RetrofitApplication.class)
public class GetLessonClassesTest {

    @Autowired
    private LessonClassApiManager lessonClassApiManager;
    private static final int CLASS_ID = 30;
    private static final int CLASS_LEVEL = 4;

    @TmsLink("TESTAM-8675")
    @Issue("AM-17059")
    @Severity(SeverityLevel.BLOCKER)
    @Tags({@Tag(POSITIVE), @Tag(GET_ALL_LESSON_CLASSES_EP)})
    @Feature(GET_ALL_LESSON_CLASSES_EP)
    @DisplayName("Тест получения всех классов страны")
    @Test
    public void getAllClasses() {
        List<LessonClassItem> allClasses = lessonClassApiManager.getAllClasses(HTTP_OK, LessonClassItem.class);
        assertFalse(allClasses.isEmpty(), "Список классов пуст");
    }

    @TmsLink("TESTAM-8675")
    @Issue("AM-17059")
    @Severity(SeverityLevel.NORMAL)
    @Tags({@Tag(POSITIVE), @Tag(GET_CLASS_BY_ID_EP)})
    @Feature(GET_CLASS_BY_ID_EP)
    @DisplayName("Тест получения класса по id")
    @Owner(CS2)
    @Test
    public void getClassById() {
        LessonClassItem res = lessonClassApiManager.getClassById(CLASS_ID, HTTP_OK, LessonClassItem.class);
        AssertionsUtil.checkFieldValuesNotNull(res);
    }

    @TmsLink("TESTAM-8675")
    @Issue("AM-17059")
    @Severity(SeverityLevel.MINOR)
    @Tags({@Tag(POSITIVE), @Tag(GET_CLASS_BY_LEVEL_EP)})
    @Feature(GET_CLASS_BY_LEVEL_EP)
    @DisplayName("Тест получения всех классов страны по уровню")
    @Test
    public void getClassByLevel() {
        List<LessonClassItem> allClasses = lessonClassApiManager.getClassByLevel(CLASS_LEVEL, HTTP_OK, LessonClassItem.class);
        assertFalse(allClasses.isEmpty(), "Список классов пуст");
    }
}
