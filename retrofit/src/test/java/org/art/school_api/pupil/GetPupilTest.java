package org.art.school_api.pupil;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import org.art.AssertionsUtil;
import org.art.RetrofitApplication;
import org.art.school.pupil.PupilItem;
import org.art.school_api.services.pupil.PupilApiManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static java.net.HttpURLConnection.HTTP_OK;
import static org.art.ApiTags.PUPIL_API;
import static org.art.Teams.CS1;
import static org.art.Teams.KORBEN_TEAM;
import static org.art.TestTags.POSITIVE;
import static org.art.school_api.services.pupil.PupilApiService.GET_ALL_PUPILS_EP;
import static org.art.school_api.services.pupil.PupilApiService.GET_PUPIL_BY_ID_EP;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic(PUPIL_API)
@Owner(CS1)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(classes = RetrofitApplication.class)
public class GetPupilTest {

    @Autowired
    private PupilApiManager pupilApiManager;
    private static final int PUPIL_ID = 911;

    @TmsLink("TESTAM-8675")
    @Issue("AM-17059")
    @Owner(KORBEN_TEAM)
    @Severity(SeverityLevel.TRIVIAL)
    @Tags({@Tag(POSITIVE), @Tag(GET_ALL_PUPILS_EP)})
    @Feature(GET_ALL_PUPILS_EP)
    @DisplayName("Тест получения всех учеников страны")
    @Test
    public void getAllPupils() {
        List<PupilItem> allPupils = pupilApiManager.getAllPupils(HTTP_OK, PupilItem.class);
        assertFalse(allPupils.isEmpty(), "Список учеников пуст");
    }

    @TmsLink("TESTAM-8675")
    @Issue("AM-17059")
    @Severity(SeverityLevel.MINOR)
    @Tags({@Tag(POSITIVE), @Tag(GET_PUPIL_BY_ID_EP)})
    @Feature(GET_PUPIL_BY_ID_EP)
    @DisplayName("Тест получения ученика по id")
    @Test
    public void getPupilById() {
        PupilItem pupilItem = pupilApiManager.getPupilById(PUPIL_ID, HTTP_OK, PupilItem.class);
        AssertionsUtil.checkFieldValuesNotNull(pupilItem);
    }
}
