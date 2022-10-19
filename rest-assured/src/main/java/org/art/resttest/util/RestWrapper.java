package org.art.resttest.util;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.specification.RequestSpecification;
import org.art.resttest.pojos.CreateUserRequest;
import org.art.resttest.pojos.CreateUserResponse;
import org.art.resttest.pojos.UserLogin;
import org.art.resttest.pojos.UserPojoFull;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RestWrapper {

    private static final String BASE_URL = "https://requres.in/api";
    private static RequestSpecification REQ_SPEC;
    private Cookies cookies;

    private RestWrapper(Cookies cookies) {
        this.cookies = cookies;

        REQ_SPEC = new RequestSpecBuilder()
                .addCookies(cookies)
                .setBaseUri("https://reqres.in/api")
                .setBasePath("/users")
                .setContentType(ContentType.JSON)
                .build();
    }

    public static RestWrapper loginAs(String login, String password) {
        Cookies cookies = given()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URL)
                .basePath("/login")
                .body(new UserLogin(login, password))
                .post()
                .getDetailedCookies();

        return new RestWrapper(cookies);
    }

    public List<UserPojoFull> getUsers() {
        return given()
                .spec(REQ_SPEC)
                .get()
                .jsonPath().getList("data", UserPojoFull.class);
    }

    public CreateUserResponse createUser(CreateUserRequest rq) {
        return given()
                .spec(REQ_SPEC)
                .body(rq)
                .post()
                .as(CreateUserResponse.class);
    }
}
