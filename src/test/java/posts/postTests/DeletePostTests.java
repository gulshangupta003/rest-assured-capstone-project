package posts.postTests;

import org.testng.Assert;
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
//        id = "634007774887a23b64c19a53";
        getAllPostsResponse = new PostsService().getAllPosts();
        id = getAllPostsResponse.getDataList().get(0).getId();
    }

    @Test
    public void shouldDeletePostById() {
        // 2. Act
        DeletePostResponse deletePostResponse = postsService.deletePost(id);

        // 3. Assert
        assertEquals(deletePostResponse.getStatusCode(), 200);
        assertEquals(deletePostResponse.getId(), id);
    }
}
