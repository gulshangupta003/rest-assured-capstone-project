package users.getAll;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class GetAllUsersResponse{

	@Setter
	private int statucCode;

	private int total;

	@JsonProperty("data")
	private List<Data> dataList;
	private int limit;
	private int page;

	@Getter
	public static class Data{
		private String firstName;
		private String lastName;
		private String id;
		private String title;
		private String picture;
	}
}