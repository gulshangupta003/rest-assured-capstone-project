package posts;

import io.restassured.response.Response;
import posts.createPost.CreatePostRequestBody;
import posts.createPost.CreatePostResponse;
import users.UsersClient;

public class PostsService {
    public CreatePostResponse createUserPosts(CreatePostRequestBody body) {
        Response response = new PostsClient().createPost(body);

        CreatePostResponse createPostResponse = response.as(CreatePostResponse.class);
        createPostResponse.setStatusCode(response.statusCode());

        return createPostResponse;
    }
}
