package org.art.tests.lessonclass;

import org.art.school.lessonclass.LessonClassItem;
import org.art.services.lessonclass.LessonClassApiManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

import static java.net.HttpURLConnection.HTTP_OK;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GetLessonClassesTest {

    private LessonClassApiManager lessonClassApiManager;

    @BeforeAll
    void setUp() {
        lessonClassApiManager = new LessonClassApiManager();
    }

    @Test
    public void getAllCities() {
        List<LessonClassItem> allClasses = lessonClassApiManager.getAllClasses(HTTP_OK, LessonClassItem.class);
    }
}
