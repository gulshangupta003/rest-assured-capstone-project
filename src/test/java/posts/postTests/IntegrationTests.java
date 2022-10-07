package posts.postTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import posts.PostsService;
import posts.createPost.CreatePostRequestBody;
import posts.createPost.CreatePostResponse;
import posts.deletePost.DeletePostResponse;

import static org.testng.Assert.assertEquals;

public class IntegrationTests {
    // 1. Arrange
    private PostsService postsService;

    @BeforeClass
    public void beforeClass() {
        postsService = new PostsService();
    }

    @Test
    public void shouldCreateAndDeletePost() {
        // 2. Act
        CreatePostRequestBody createPostRequestBody = new CreatePostRequestBody.Builder()
                .text("shouldCreateAndDeletePost test")
                .likes(22)
                .build();

        CreatePostResponse createPostResponse = postsService.createPost(createPostRequestBody);

        // 3. Assert
        assertEquals(createPostResponse.getStatusCode(), 200);
        assertEquals(createPostResponse.getText(), createPostRequestBody.getText());
        assertEquals(createPostResponse.getLikes(), createPostRequestBody.getLikes());

        DeletePostResponse deletePostResponse = postsService.deletePost(createPostResponse.getId());

        assertEquals(deletePostResponse.getStatusCode(), 200);
        assertEquals(deletePostResponse.getId(), createPostResponse.getId());
        deletePostResponse.assertDelete(createPostResponse.getId());
    }
}
