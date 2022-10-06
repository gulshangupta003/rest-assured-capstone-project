import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersService;
import users.create.CreateUserRequestBody;
import users.create.response.CreateUserErrorResponse;

import static org.testng.Assert.*;

public class CreateUserNegativeTests {
    private UsersService usersService;

    @BeforeClass
    public void beforeClass() {
        usersService = new UsersService();
    }

    @Test
    public void shouldNotAllowToCreateUserWithExistingEmail() {
        // 1. Arrange
        CreateUserRequestBody requestBody = new CreateUserRequestBody.Builder()
                .email("roshan1@gmail.com")
                .build();

        // 2. Act
        CreateUserErrorResponse errorResponse = usersService.createUserExpectingError(requestBody);

        // 3. Assert
        assertEquals(errorResponse.getStatusCode(), 400);
        assertEquals(errorResponse.getError(), "BODY_NOT_VALID");
        assertEquals(errorResponse.getData().getEmail(), "Email already used");
    }
}
