package users;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import users.create.CreateUserRequestBody;

import static io.restassured.RestAssured.given;

public class UsersClient {

    public static Response getAll() {
        Response response =
                given()
                        .header("app-id", "633d82042ba9894b482d72d3")
                .when()
                    .get("https://dummyapi.io/data/v1//user");

        response
                .then()
                    .log().body();

        return response;
    }

    public static Response get(String id) {
        Response response =
                given()
                        .header("app-id", "633d82042ba9894b482d72d3")
                        .pathParam("id", id)
                        .when()
                        .get("https://dummyapi.io/data/v1//user/{id}");
        response
                .then()
                .log().body();

        return response;
    }

    public Response create(CreateUserRequestBody body) {
        Response response =
                given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .header("app-id", "633d82042ba9894b482d72d3")
                    .body(body)
                .when()
                    .post("https://dummyapi.io/data/v1/user/create");

        response.then()
                .log().body();

        return response;
    }

    public Response getAllCreatedUnderYourAccount() {
        Response response =
                given()
                        .header("app-id", "633d82042ba9894b482d72d3")
                        .queryParam("created", "1")
                .when()
                        .get("https://dummyapi.io/data/v1//user");

        response
                .then()
                .log().body();

        return response;
    }
}
