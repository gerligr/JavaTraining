package course.jse.jdbc.project;

import lombok.Data;

@Data
public class UserDto {
	private int id;
	private int departmentId; //should be later replaced with DepartmentDto object
	private int teamId; //should be later replaced with TeamDto object
	private int roleId; //should be later replaced with RoleDto object
	private String firstname;
	private String lastname;
	private String username;
	private String password;

}
