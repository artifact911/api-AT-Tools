package org.art.util;

import org.art.model.City;
import org.art.storage.EntityStorage;
import org.junit.jupiter.api.Test;

import java.util.List;

class RandomGeneratorUtilTest {

    @Test
    void getRandomCitiesList() {
        List<City> randomCitiesList = EntityStorage.getCities();
        System.out.println();
    }
}