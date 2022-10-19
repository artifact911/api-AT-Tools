package org.art.resttest.steps;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.art.resttest.pojos.CreateUserRequest;
import org.art.resttest.pojos.CreateUserResponse;
import org.art.resttest.pojos.UserPojoFull;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UserSteps {

    private static final RequestSpecification REQ_SPEC =
            new RequestSpecBuilder()
                    .setBaseUri("https://reqres.in/api")
                    .setBasePath("/users")
                    .setContentType(ContentType.JSON)
                    .build();

    public static List<UserPojoFull> getUsers() {
        return given()
                .spec(REQ_SPEC)
                .get()
                .jsonPath().getList("data", UserPojoFull.class);
    }


    private CreateUserResponse user;

    public CreateUserResponse createUser(CreateUserRequest rq) {
        user = given()
                .body(rq)
                .post()
                .as(CreateUserResponse.class);
        return user;
    }

    public UserPojoFull getUser() {
        return given().get("/" + user.getId()).as(UserPojoFull.class);
    }


}
