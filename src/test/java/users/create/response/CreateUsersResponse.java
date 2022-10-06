package users.create.response;

import lombok.Getter;
import lombok.Setter;
import users.create.CreateUserRequestBody;

import static org.testng.Assert.assertEquals;

@Getter
public class CreateUsersResponse{
	@Setter
	private int statusCode;

	private String firstName;
	private String lastName;
	private String id;
	private String updatedDate;
	private String email;
	private String registerDate;

	public void assertUser(CreateUserRequestBody requestBody) {
		assertEquals(this.getStatusCode(), 200);
		assertEquals(this.email, requestBody.getEmail());
	}
}