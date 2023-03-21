package org.art.tests.city;

import org.art.school.city.CityItem;
import org.art.services.city.CityApiManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

import static java.net.HttpURLConnection.HTTP_OK;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GetCityTest {

    private CityApiManager cityApiManager;

    @BeforeAll
    void setUp() {
       cityApiManager = new CityApiManager();
    }

    @Test
    public void getAllCities() {
        List<CityItem> allCities = cityApiManager.getAllCities(HTTP_OK, CityItem.class);
    }
}
