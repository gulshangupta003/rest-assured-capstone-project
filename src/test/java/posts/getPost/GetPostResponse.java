package posts.getPost;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class GetPostResponse{
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
	private List<Object> tags;

	@Getter
	public static class Owner{
		private String firstName;
		private String lastName;
		private String id;
	}
}