package org.art.spaceport_api;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import lombok.SneakyThrows;
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
import static org.art.ExpectedResultUtils.PATH_TO_EXPECTED_FOLDER;
import static org.art.ExpectedResultUtils.getObjectFromResourceWithMapper1;
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
    private static final String PATH_JSON_TEST = PATH_TO_EXPECTED_FOLDER + "spaceport/getSpaceportList.json";

    @Tags({@Tag(POSITIVE), @Tag(GET_ALL_SPACEPORT_EP)})
    @Feature(GET_ALL_SPACEPORT_EP)
    @DisplayName("Тест получения транспорта из списка")
    @Test
    void getAllSpaceports() {
        GetAllSpaceportResp allSpaceport = getAllSpaceportResp();

        PlaneField plane = (PlaneField) findValueFieldByPredicate(allSpaceport.getValueField(),
                (ValueField vf) -> ValueFieldType.PLANE.equals(vf.getType()));

        assertEquals(PLANE_ID, plane.id(), "No such id");
    }

    @Test
    @SneakyThrows
    void checkSpaceportList() {
// Способ 1
//        ObjectMapper mapper = getInstanceObjectMapper();
//        Object resource = ExpectedResultUtils.getObjectFromResource(PATH_JSON_TEST, Object.class);
//        GetAllSpaceportResp resp = mapper.readValue(mapper.writeValueAsString(resource), GetAllSpaceportResp.class);


        GetAllSpaceportResp resp = getObjectFromResourceWithMapper1(PATH_JSON_TEST, GetAllSpaceportResp.class);


        assertEquals(resp, getAllSpaceportResp());
    }

    private GetAllSpaceportResp getAllSpaceportResp() {
        return spaceportManager
                .getAllSpaceport(GET_ALL_SPACEPORT_EP, HTTP_OK, GetAllSpaceportResp.class);
    }
}
