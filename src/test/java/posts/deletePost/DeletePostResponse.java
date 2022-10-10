package posts.deletePost;

import lombok.Getter;
import lombok.Setter;
import posts.PostsService;
import posts.getAllPosts.GetAllPostsResponse;

import static org.testng.Assert.assertEquals;

@Getter
public class DeletePostResponse {
	@Setter
	private int statusCode;

	private String id;

	public void assertDelete(String id) {
		GetAllPostsResponse allPosts = new PostsService().getAllPosts();
		assertEquals(allPosts.hasPost(id), false);
	}
}