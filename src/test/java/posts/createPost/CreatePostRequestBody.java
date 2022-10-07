package posts.createPost;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CreatePostRequestBody{
	private String owner;
	private String image;
	private String text;
	private int likes;
	@JsonProperty("tags")
	private List<String> tags;

	public CreatePostRequestBody(Builder builder) {
		this.owner = builder.owner;
		this.image = builder.image;
		this.text = builder.text;
		this.likes = builder.likes;
		this.tags = builder.tags;
	}

	public static class Builder {
		private String owner;
		private String image;
		private String text;
		private int likes;
		private List<String> tags;

		public Builder() {
			this.owner = "633efa4613e713b5e2c31c2b";
			this.image = "";
			this.text = "Welcome to my new blog";
			this.likes = 0;
			this.tags = new ArrayList<String>();
			tags.add("Hi");tags.add("Hello");tags.add("Namaste");
		}

		public Builder owner(String owner) {
			this.owner = owner;
			return this;
		}

		public Builder image(String image) {
			this.image = image;
			return this;
		}

		public Builder text(String text) {
			this.text = text;
			return this;
		}

		public Builder likes(int likes) {
			this.likes = likes;
			return this;
		}

		public Builder tags(List<String> tags) {
			this.tags = tags;
			return this;
		}

		public CreatePostRequestBody build() {
			CreatePostRequestBody createPostRequestBody = new CreatePostRequestBody(this);
			return createPostRequestBody;
		}
	}
}