package org.art.tests.pupil;

import org.art.school.pupil.PupilItem;
import org.art.services.pupil.PupilApiManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

import static java.net.HttpURLConnection.HTTP_OK;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GetPupilTest {

    private PupilApiManager pupilApiManager;

    @BeforeAll
    void setUp() {
        pupilApiManager = new PupilApiManager();
    }

    @Test
    public void getAllPupils() {
        List<PupilItem> allPupils = pupilApiManager.getAllPupils(HTTP_OK, PupilItem.class);
        System.out.println();
    }
}
