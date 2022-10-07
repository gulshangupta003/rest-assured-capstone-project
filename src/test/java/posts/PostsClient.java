package posts;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import posts.createPost.CreatePostRequestBody;

import static io.restassured.RestAssured.given;

public class PostsClient {
    public Response createPost(CreatePostRequestBody body) {
        Response response =
            given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .header("app-id", "633d82042ba9894b482d72d3")
                    .body(body)
                .when()
                    .post("https://dummyapi.io/data/v1/post/create");

        response
                .then()
                    .log().body();

        return response;
    }
}
