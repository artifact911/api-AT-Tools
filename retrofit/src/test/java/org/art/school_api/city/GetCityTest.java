package org.art.school_api.city;

import io.qameta.allure.*;
import org.art.AssertionsUtil;
import org.art.RetrofitApplication;
import org.art.school.city.CityItem;
import org.art.school_api.services.city.CityApiManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static java.net.HttpURLConnection.HTTP_OK;
import static org.art.ApiTags.CITY_API;
import static org.art.Teams.KORBEN_TEAM;
import static org.art.Teams.YUSHA_TEAM;
import static org.art.TestTags.NEGATIVE;
import static org.art.TestTags.POSITIVE;
import static org.art.school_api.services.city.CityApiService.GET_ALL_CITIES_EP;
import static org.art.school_api.services.city.CityApiService.GET_CITY_BY_ID_EP;
import static org.junit.jupiter.api.Assertions.assertFalse;

@Epic(CITY_API)
@Owner(KORBEN_TEAM)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(classes = RetrofitApplication.class)
public class GetCityTest {

    @Autowired
    private CityApiManager cityApiManager;

    @TmsLink("TESTAM-8675")
    @Issue("AM-17059")
    @Severity(SeverityLevel.NORMAL)
    @Tags({@Tag(POSITIVE), @Tag(GET_ALL_CITIES_EP)})
    @Feature(GET_ALL_CITIES_EP)
    @DisplayName("Тест получения всех городов")
    @Test
    public void getAllCities() {
        List<CityItem> allCities = cityApiManager.getAllCities(HTTP_OK, CityItem.class);
        assertFalse(allCities.isEmpty(), "Список городов пуст");
    }

    @TmsLink("TESTAM-8675")
    @Issue("AM-17059")
    @Severity(SeverityLevel.CRITICAL)
    @Tags({@Tag(POSITIVE), @Tag(GET_CITY_BY_ID_EP)})
    @Feature(GET_CITY_BY_ID_EP)
    @DisplayName("Тест получения города по id")
    @ParameterizedTest(name = "id - {0}")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12})
    public void getCityById(int cityId) {
        CityItem cityRes = cityApiManager.getCityById(cityId, HTTP_OK, CityItem.class);
        AssertionsUtil.checkFieldValuesNotNull(cityRes);
    }

    @TmsLink("TESTAM-8675")
    @Issue("AM-17059")
    @Owner(YUSHA_TEAM)
    @Severity(SeverityLevel.CRITICAL)
    @Tags({@Tag(NEGATIVE), @Tag(GET_CITY_BY_ID_EP)})
    @Feature(GET_CITY_BY_ID_EP)
    @DisplayName("Тест получения несуществующего города")
    @Test
    public void getCityById() {
        CityItem cityRes = cityApiManager.getCityById(11, HTTP_OK, CityItem.class);
        AssertionsUtil.checkFieldValuesNotNull(cityRes);
    }
}
