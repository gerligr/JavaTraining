package com.cid.model;

import lombok.Data;

@Data
public class User {
	private int id;
	private int departmentId;
	private int teamId;
	private int roleId;
	private String firstname;
	private String lastname;
	private String username;
	private String password;		
		
}
