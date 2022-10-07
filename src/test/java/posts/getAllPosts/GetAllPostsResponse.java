package posts.getAllPosts;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
public class GetAllPostsResponse{
	@Setter
	private int statusCode;

	private int total;
	@JsonProperty("data")
	private List<Data> dataList;
	private int limit;
	private int page;

	@Getter
	public static class Data {
		private Owner owner;
		private String image;
		private String publishDate;
		private String id;
		private String text;
		private String updatedDate;
		private int likes;
		@JsonProperty("tags")
		private List<String> tags;
	}

	@Getter
	public static class Owner{
		private String firstName;
		private String lastName;
		private String id;
	}

	public boolean hasPost(String id) {
		return dataList.stream()
				.filter(data -> data.getId().equals(id))
				.findFirst()
				.isPresent();
	}
}