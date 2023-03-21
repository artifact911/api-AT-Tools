package org.art.tests.schools;

import org.art.school.school.SchoolItem;
import org.art.services.school.SchoolApiManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

import static java.net.HttpURLConnection.HTTP_OK;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GetSchoolTest {

    private SchoolApiManager schoolApiManager;

    @BeforeAll
    void setUp() {
        schoolApiManager = new SchoolApiManager();
    }

    @Test
    public void getAllCities() {
        List<SchoolItem> allPupils = schoolApiManager.getAllSchools(HTTP_OK, SchoolItem.class);
        System.out.println();
    }
}
