import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersService;
import users.getAll.GetAllUsersResponse;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class GetAllUsersTests {
    // 1. Arrange

    private UsersService usersService;

    @BeforeClass
    public void beforeClass() {
        usersService = new UsersService();
    }

    @Test
    public void shouldGetAllUsers() {
        // 2. Act
        GetAllUsersResponse getAllUsersResponse = usersService.getAllUsers();

        // 3. Assert
        assertEquals(getAllUsersResponse.getStatucCode(), 200);
        assertEquals(getAllUsersResponse.getDataList().size(), 20);
    }
}
