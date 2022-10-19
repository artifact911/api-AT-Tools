package org.art.resttest;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.art.resttest.pojos.CreateUserRequest;
import org.art.resttest.pojos.CreateUserResponse;
import org.art.resttest.pojos.UserPojoFull;
import org.art.resttest.steps.UserSteps;
import org.art.resttest.util.RestWrapper;
import org.art.resttest.util.UserGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_OK;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class RestTest {

    private static RestWrapper api;

    @BeforeAll
    public static void prepareClient(){
        api = RestWrapper.loginAs("eve.holt@reqres.in", "citysLicka");
    }

    private static final RequestSpecification REQ_SPEC =
            new RequestSpecBuilder()
                    .setBaseUri("https://reqres.in/api")
                    .setBasePath("/users")
                    .setContentType(ContentType.JSON)
                    .build();

    @Test
    public void getUsers1(){
        List<UserPojoFull> users = UserSteps.getUsers();
        assertThat(users).extracting(UserPojoFull::getEmail).contains("emma.wong@reqres.in");
    }

    @Test
    public void getUsersAsPassword(){
        assertThat(api.getUsers()).extracting(UserPojoFull::getEmail).contains("emma.wong@reqres.in");
    }

    @Test
    public void getUsers() {
        given()
                .baseUri("https://reqres.in/api")
                .basePath("/users")
                .contentType(ContentType.JSON)
                .when().get()
                .then().statusCode(HTTP_OK);
    }

    @Test
    public void expect() {
        // после expect() если что-то упадет, по продолжит все выполняться по цепочке.
        // Излишнее
        given()
                .baseUri("https://reqres.in/api")
                .basePath("/users")
                .contentType(ContentType.JSON)
                .expect()
                .statusCode(HTTP_OK)
                .contentType(ContentType.JSON)
                .when().get()
                .then().statusCode(HTTP_OK);
    }

    @Test
    public void likeString() {
        final String responseString = given()
                .baseUri("https://reqres.in/api")
                .basePath("/users")
                .contentType(ContentType.JSON)
                .when().get()
                .then().statusCode(HTTP_OK)
                .extract().asString();
    }

    @Test
    public void array() {
        // Обращение к массиву
        given()
                .baseUri("https://reqres.in/api")
                .basePath("/users")
                .contentType(ContentType.JSON)
                .when().get()
                .then().statusCode(200)
                .body("data[0].email", equalTo("george.bluth@reqres.in"));

        // Лямбда внизу
        given()
                .baseUri("https://reqres.in/api")
                .basePath("/users")
                .contentType(ContentType.JSON)
                .when().get()
                .then().statusCode(200)
                .body("data.find{it.email=='george.bluth@reqres.in'}.first_name", equalTo("George"));
    }

    @Test
    public void getList() {
        final List<String> emailList = given()
                .baseUri("https://reqres.in/api")
                .basePath("/users")
                .contentType(ContentType.JSON)
                .when().get()
                .then().statusCode(HTTP_OK)
                .extract().jsonPath().getList("data.email");
    }

    @Test
    public void fillPojo() {
        final List<UserPojoFull> userFullPojoList = given()
                .spec(REQ_SPEC)
                .when().get()
                .then().statusCode(HTTP_OK)
                .extract().jsonPath().getList("data", UserPojoFull.class);

        assertThat(userFullPojoList).extracting(UserPojoFull::getEmail).contains("george.bluth@reqres.in");

    }

    @Test
    public void createUser() {
        CreateUserRequest rq = UserGenerator.getSimpleUser();

        CreateUserResponse rs = given()
                .spec(REQ_SPEC)
                .body(rq)
                .when().post()
                .then().extract().as(CreateUserResponse.class);

        //next option
      /*  UserSteps userApi = new UserSteps();
        CreateUserResponse rs2 = userApi.createUser(rq);*/

        assertThat(rs)
                .isNotNull()
                .extracting(CreateUserResponse::getName)
                .isEqualTo(rq.getName());

      /*  assertThat(rs2)
                .isNotNull()
                .extracting(CreateUserResponse::getName)
                .isEqualTo(rq.getName());*/
    }
}
