package org.art.spaceport_api;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.art.RetrofitApplication;
import org.art.dynamic_fields.ValueField;
import org.art.dynamic_fields.ValueFieldType;
import org.art.dynamic_fields.pojos.PlaneField;
import org.art.feature_api.spaceport_api.services.SpaceportManager;
import org.art.spaceport.GetAllSpaceportResp;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static java.net.HttpURLConnection.HTTP_OK;
import static org.art.ApiTags.SPACEPORT_API;
import static org.art.Teams.KORBEN_TEAM;
import static org.art.TestTags.POSITIVE;
import static org.art.dynamic_fields.ValueField.findValueFieldByPredicate;
import static org.art.feature_api.spaceport_api.services.SpaceportService.GET_ALL_SPACEPORT_EP;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic(SPACEPORT_API)
@Owner(KORBEN_TEAM)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(classes = RetrofitApplication.class)
public class GetAllSpaceportTest {

    @Autowired
    private SpaceportManager spaceportManager;

    private static final String PLANE_ID = "#PLANE";

    @Tags({@Tag(POSITIVE), @Tag(GET_ALL_SPACEPORT_EP)})
    @Feature(GET_ALL_SPACEPORT_EP)
    @DisplayName("Тест получения всех космодромов")
    @Test
    void getAllSpaceports() {
        GetAllSpaceportResp allSpaceport = spaceportManager
                .getAllSpaceport(GET_ALL_SPACEPORT_EP, HTTP_OK, GetAllSpaceportResp.class);

        PlaneField plane = (PlaneField) findValueFieldByPredicate(allSpaceport.getValueField(),
                (ValueField vf) -> ValueFieldType.PLANE.equals(vf.getType()));

        assertEquals(PLANE_ID, plane.id(), "No such id");
    }
}
