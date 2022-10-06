import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersService;
import users.get.GetUserResponse;

public class GetUserTests {

    // 1. Arrange
    private UsersService usersService;

    @BeforeClass
    public void beforeClass() {
        usersService = new UsersService();
    }

    @Test
    public void shouldGetUser() {

        // 2. Act
        GetUserResponse getUserResponse = usersService.getUser("60d0fe4f5311236168a109dd");

        String id = getUserResponse.getId();

        // 3. Assert
        Assert.assertEquals(id, "60d0fe4f5311236168a109dd");
    }
}
