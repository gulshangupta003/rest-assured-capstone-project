package users;

import io.restassured.response.Response;
import users.get.GetUserResponse;
import users.getAll.GetAllUsersResponse;

public class UsersService {
    public static GetAllUsersResponse getAllUsers() {
        Response response = new UsersClient().getAll();

        int statusCode = response.statusCode();

        GetAllUsersResponse getAllUsersResponse = response.as(GetAllUsersResponse.class);
        getAllUsersResponse.setStatucCode(statusCode);

        return getAllUsersResponse;
    }

    public GetUserResponse getUser(String id) {
        Response response = new UsersClient().get(id);
        response
                .then()
                .log().body();

        int statusCode = response.statusCode();

        GetUserResponse getUsersResponse = response.as(GetUserResponse.class);
        getUsersResponse.setStatusCode(statusCode);

        return getUsersResponse;
    }
}
