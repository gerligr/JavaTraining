package course.jse.jdbc.project;

import lombok.Data;

@Data
public class UserModel {
	private int id;
	private int departmentId;
	private int teamId;
	private int roleId;
	private String firstname;
	private String lastname;
	private String username;
	private String password;
		
	
	public UserModel(int id, int departmentId, int teamId, int roleId, String firstname, String lastname,
			String username, String password) {
		super();
		this.id = id;
		this.departmentId = departmentId;
		this.teamId = teamId;
		this.roleId = roleId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
	}

	public UserModel() {
		super();
	}

	
}
