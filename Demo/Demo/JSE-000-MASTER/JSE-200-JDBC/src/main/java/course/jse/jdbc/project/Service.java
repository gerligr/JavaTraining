package course.jse.jdbc.project;

import java.util.ArrayList;

public class Service {

	public static void main(String[] args) {
		
		UserDao userDao = new UserDao();	
		
		UserModel newUser = new UserModel();
		newUser.setDepartmentId(2);
		newUser.setTeamId(3);
		newUser.setRoleId(3);
		newUser.setFirstname("Siiri");
		newUser.setLastname("Muhu");
		newUser.setUsername("siiri.muhu@cid.com");
		newUser.setPassword("muhu1234");	
				
		userDao.createUser(newUser);
		
		userDao.loadAllUsers();
		
		UserModel foundUser = userDao.findById(7);		
		System.out.println("UserModel values: "+foundUser.toString());	
		
		ArrayList<UserModel> usersList = userDao.findByTeamId(4);
		System.out.println("UserList values: "+usersList.toString());	
		
		userDao.deleteUser(28);		
		
		UserModel userToUpdate = new UserModel();
		newUser.setDepartmentId(2);
		newUser.setTeamId(3);
		newUser.setRoleId(3);
		newUser.setFirstname("Reet");
		newUser.setLastname("Muhu");
		newUser.setUsername("siiri.muhu@cid.com");
		newUser.setPassword("muhu1234");	
		
		userDao.updateUser(37, userToUpdate);
		
		
	}

}
