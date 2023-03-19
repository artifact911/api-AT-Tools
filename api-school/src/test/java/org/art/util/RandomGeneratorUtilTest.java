package org.art.util;

import org.art.model.City;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RandomGeneratorUtilTest {

    @Test
    void getRandomCitiesList() {
        List<City> randomCitiesList = RandomGeneratorUtil.getRandomCitiesList(12);
        System.out.println();
    }
}