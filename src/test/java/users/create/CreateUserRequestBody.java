package users.create;

import lombok.Getter;

import java.util.UUID;

@Getter
public class CreateUserRequestBody {
	private String lastName;
	private String firstName;
	private String email;

	public CreateUserRequestBody(Builder builder) {
		this.lastName = builder.lastName;
		this.firstName = builder.firstName;
		this.email = builder.email;
	}

	public static class Builder {

		private String lastName;
		private String firstName;
		private String email;

		public Builder() {
			this.lastName = "Rahul";
			this.firstName = "Kumar";
			this.email = String.format("%s@gmail.com", UUID.randomUUID());
		}

		public Builder lastName(String lastName) {
			this.lastName = lastName;

			return this;
		}

		public Builder firstName(String firstName) {
			this.firstName = firstName;

			return this;
		}

		public Builder email(String email) {
			this.email = email;

			return this;
		}

		public CreateUserRequestBody build() {
			CreateUserRequestBody createUsersRequestBody = new CreateUserRequestBody(this);

			return createUsersRequestBody;
		}
	}
}