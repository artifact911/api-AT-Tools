package org.art.in.reqres;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.art.in.reqres.GlobalVariables.GET_USERS_PATH;
import static org.art.in.reqres.GlobalVariables.URL;

public class GetListUsersTest {

    @Test
    void getRequestTest() {
        Response res = given()
                .baseUri(URL)
                .basePath(GET_USERS_PATH)
                .contentType(ContentType.JSON)
                .when()
                .get()
                .then()
                .extract()
                .as(Response.class);
    }

    @Test
    void getUserList() {
        List<Data> dataList = given()
                .baseUri(URL)
                .basePath(GET_USERS_PATH)
                .contentType(ContentType.JSON)
                .when()
                .get()
                .then()
                .extract()
                .jsonPath()
                .getList("data", Data.class);
    }
}
