package org.art.tests.lessonclass;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import org.art.AssertionsUtil;
import org.art.school.lessonclass.LessonClassItem;
import org.art.services.lessonclass.LessonClassApiManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

import static java.net.HttpURLConnection.HTTP_OK;
import static org.art.ApiTags.LESSON_CLASS_API;
import static org.art.Teams.CS2;
import static org.art.Teams.JOVE_TEAM;
import static org.art.TestTags.POSITIVE;
import static org.art.services.lessonclass.LessonClassApiService.GET_ALL_LESSON_CLASSES_EP;
import static org.art.services.lessonclass.LessonClassApiService.GET_CLASS_BY_ID_EP;
import static org.art.services.lessonclass.LessonClassApiService.GET_CLASS_BY_LEVEL_EP;
import static org.junit.jupiter.api.Assertions.assertFalse;

@Epic(LESSON_CLASS_API)
@Owner(JOVE_TEAM)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GetLessonClassesTest {

    private LessonClassApiManager lessonClassApiManager;
    private static final String CLASS_ID = "7-D";
    private static final int CLASS_LEVEL = 4;

    @DisplayName("Подготовка тестовых данных")
    @BeforeAll
    void setUp() {
        lessonClassApiManager = new LessonClassApiManager();
    }

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
    @DisplayName("Тест получения всех класса по id")
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
