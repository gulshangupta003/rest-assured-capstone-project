import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersService;
import users.create.CreateUserRequestBody;
import users.create.response.CreateUsersResponse;

public class CreateUserTests {
    private UsersService usersService;

    @BeforeClass
    public void beforeClass() {
        usersService = new UsersService();
    }

    @Test
    public void shouldCreateUser() {
        // 1. Arrange
        CreateUserRequestBody requestBody =  new CreateUserRequestBody.Builder()
                .build();

        // 2. Act
        CreateUsersResponse createUsersResponse = usersService.createUser(requestBody);

        // 3. Assert
        createUsersResponse.assertUser(requestBody);
    }
}
