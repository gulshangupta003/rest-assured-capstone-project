package posts.postTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import posts.PostsService;
import posts.deletePost.DeletePostResponse;
import posts.getAllPosts.GetAllPostsResponse;

import static org.testng.Assert.*;

public class DeletePostTests {
    // 1. Arrange
    private PostsService postsService;
    private String id;
    GetAllPostsResponse getAllPostsResponse;

    @BeforeClass
    public void beforeClass() {
        postsService = new PostsService();
        getAllPostsResponse = new PostsService().getAllPosts();
        id = getAllPostsResponse.getRandomPostId();
    }

    @Test
    public void shouldDeletePostById() {
        // 2. Act
        DeletePostResponse deletePostResponse = postsService.deletePost(id);

        // 3. Assert
        assertEquals(deletePostResponse.getStatusCode(), 200);
        assertEquals(deletePostResponse.getId(), id);
        deletePostResponse.assertDelete(id);
    }
}
