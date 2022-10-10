package posts.postTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import posts.PostsService;
import posts.getAllPosts.GetAllPostsResponse;
import posts.getPost.GetPostResponse;

import static org.testng.Assert.*;

public class GetPostTests {
    // 1. Arrange
    private PostsService postsService;
    private String id;
    private GetAllPostsResponse getAllPostsResponse;

    @BeforeClass
    public void beforeClass() {
        postsService = new PostsService();

        getAllPostsResponse = new PostsService().getAllPosts();
        id = getAllPostsResponse.getRandomPostId();
    }

    @Test
    public void shouldGetPostById() {
        // 2. Act
        GetPostResponse getPostResponse = postsService.getPost(id);

        // 3. Assert
        assertEquals(getPostResponse.getStatusCode(), 200);
        assertEquals(getPostResponse.getId(), id);
    }
}
