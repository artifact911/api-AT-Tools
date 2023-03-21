package org.art.util;

import org.art.model.City;
import org.art.model.Pupil;
import org.art.storage.EntityStorage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

class RandomGeneratorUtilTest {

    private static List<City> randomCitiesList;

    @BeforeAll
    public static void setUp() {
        randomCitiesList = EntityStorage.getCities();
    }

    @Test
    void getPupilsList() {
        List<Pupil> collect = randomCitiesList.stream()
                                              .flatMap(city -> city.getSchools().stream())
                                              .flatMap(school -> school.getLessonClassList().stream())
                                              .flatMap(lessonClass -> lessonClass.getPupils().stream())
                                              .collect(Collectors.toList());

        System.out.println();
    }
}