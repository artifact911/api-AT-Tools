package org.art.tests.schools;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import org.art.AssertionsUtil;
import org.art.school.school.SchoolItem;
import org.art.services.school.SchoolApiManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

import static java.net.HttpURLConnection.HTTP_OK;
import static org.art.ApiTags.SCHOOL_API;
import static org.art.Teams.CS2;
import static org.art.Teams.KORBEN_TEAM;
import static org.art.TestTags.POSITIVE;
import static org.art.services.school.SchoolApiService.GET_ALL_SCHOOLS_EP;
import static org.art.services.school.SchoolApiService.GET_SCHOOL_BY_ID_EP;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic(SCHOOL_API)
@Owner(CS2)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GetSchoolTest {

    private SchoolApiManager schoolApiManager;
    private static final int SCHOOL_ID = 3;

    @DisplayName("Подготовка тестовых данных")
    @BeforeAll
    void setUp() {
        schoolApiManager = new SchoolApiManager();
    }

    @TmsLink("TESTAM-8675")
    @Issue("AM-17059")
    @Owner(KORBEN_TEAM)
    @Severity(SeverityLevel.MINOR)
    @Tags({@Tag(POSITIVE), @Tag(GET_ALL_SCHOOLS_EP)})
    @Feature(GET_ALL_SCHOOLS_EP)
    @DisplayName("Тест получения всех классов страны")
    @Test
    public void getAllCities() {
        List<SchoolItem> allSchools = schoolApiManager.getAllSchools(HTTP_OK, SchoolItem.class);
        assertTrue(allSchools.isEmpty(), "Список школ пуст");
    }

    @TmsLink("TESTAM-8675")
    @Issue("AM-17059")
    @Severity(SeverityLevel.CRITICAL)
    @Tags({@Tag(POSITIVE), @Tag(GET_SCHOOL_BY_ID_EP)})
    @Feature(GET_SCHOOL_BY_ID_EP)
    @DisplayName("Тест получения всех классов страны")
    @Test
    public void getSchoolById() {
        SchoolItem school = schoolApiManager.getSchoolById(SCHOOL_ID, HTTP_OK, SchoolItem.class);
        AssertionsUtil.checkFieldValuesNotNull(school);
    }
}
