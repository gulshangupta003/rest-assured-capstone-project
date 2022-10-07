package posts;

import io.restassured.response.Response;
import posts.createPost.CreatePostRequestBody;
import posts.createPost.CreatePostResponse;
import posts.deletePost.DeletePostResponse;
import posts.getPost.GetPostResponse;

public class PostsService {
    public CreatePostResponse createPosts(CreatePostRequestBody body) {
        Response response = new PostsClient().create(body);

        CreatePostResponse createPostResponse = response.as(CreatePostResponse.class);
        createPostResponse.setStatusCode(response.statusCode());

        return createPostResponse;
    }

    public GetPostResponse getPost(String id) {
        Response response = new PostsClient().get(id);
        int statusCode = response.statusCode();
        GetPostResponse getPostResponse = response.as(GetPostResponse.class);
        getPostResponse.setStatusCode(statusCode);
        return getPostResponse;
    }

    public DeletePostResponse deletePost(String id) {
        Response response = new PostsClient().delete(id);
        int statusCode = response.statusCode();
        DeletePostResponse deletePostResponse = response.as(DeletePostResponse.class);
        deletePostResponse.setStatusCode(statusCode);
        return deletePostResponse;
    }
}
