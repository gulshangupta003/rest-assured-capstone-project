package posts.createPost;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static org.testng.Assert.assertEquals;

@Getter
public class CreatePostResponse{

	@Setter
	private int statusCode;

	private Owner owner;
	private String image;
	private String link;
	private String publishDate;
	private String id;
	private String text;
	private String updatedDate;
	private int likes;
	@JsonProperty
	private List<String> tags;

	public void assertPost(CreatePostRequestBody requestBody) {
		assertEquals(this.getStatusCode(), 200);
		assertEquals(this.text, requestBody.getText());
		assertEquals(this.likes, requestBody.getLikes());
	}

	@Getter
	public static class Owner{
		private String firstName;
		private String lastName;
		private String id;
	}
}