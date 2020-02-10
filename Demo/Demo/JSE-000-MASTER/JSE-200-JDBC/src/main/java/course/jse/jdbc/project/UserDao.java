package course.jse.jdbc.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.commons.dbcp2.BasicDataSource;

import course.jse.jdbc.utils.DbUtils;

public class UserDao {
	
	public void createUser(UserModel newUser) {
		BasicDataSource datasource = getDataSource();
		
        Connection conn =null;
        			
		try{
			conn = datasource.getConnection();;
			
			System.out.println ("Connected to Database...");        
         
            PreparedStatement pstNewUser = conn.prepareStatement("INSERT INTO USER (department_id,team_id,role_id,firstname,lastname,username,password) " +
																	"VALUES (?,?,?,?,?,?,?)");   
            pstNewUser.setInt(1, newUser.getDepartmentId());
            pstNewUser.setInt(2, newUser.getTeamId());
            pstNewUser.setInt(3, newUser.getRoleId());
            pstNewUser.setString(4, newUser.getFirstname());
            pstNewUser.setString(5, newUser.getLastname());
            pstNewUser.setString(6, newUser.getUsername());
            pstNewUser.setString(7, newUser.getLastname());
            
            pstNewUser.executeUpdate();	 		
            
        }
        catch (Exception e){
           
        	System.err.println ("Impossible to connect to Database");
        	 e.printStackTrace();            
        }
        finally {
           DbUtils.closeConnection(conn);         
        }

	};
	
	public void loadAllUsers(){
		
		Connection conn = null;		
			
		try
		{				
			conn = DbUtils.createConnection();
			System.out.println ("Connected to Database...");
			
			Statement cmd = conn.createStatement();
			
			String sql = "SELECT * from user";
			ResultSet res = cmd.executeQuery(sql);	
			
			while (res.next()) {
	        	
	        	// from position
		        //System.out.print("\t"+res.getString(3));
		        //System.out.print("\t"+res.getString(4));
	        	
	        	//from column name
	        	System.out.print("\t"+res.getString("firstname"));
	        	System.out.print("\t"+res.getString("lastname"));
		        System.out.println();
			}	
		}
		
		catch (Exception e) {
			System.err.println("Impossible to connect to Database");
			e.printStackTrace();
			
		} finally {
			 DbUtils.closeConnection(conn);    
		}
		
	}
	
	public UserModel findById (int id) {
		Connection conn = null;
		UserModel found = null;
			
		try{
				
			conn = DbUtils.createConnection();
			
			Statement cmd = conn.createStatement();
			String sql = "select * from user where id= " + id;

			ResultSet res = cmd.executeQuery(sql);

			if (res.next()) {
				
				found = new UserModel();
				found.setDepartmentId(res.getInt("department_id"));
				found.setTeamId(res.getInt("team_id"));
				found.setRoleId(res.getInt("role_id"));
				found.setFirstname(res.getString("firstname"));
				found.setLastname(res.getString("lastname"));
				found.setUsername(res.getString("username"));
				found.setPassword(res.getString("password"));				
			}
		}

		catch (Exception e) {

			System.err.println("Impossible to connect to Database");
			e.printStackTrace();

		} finally {
			 DbUtils.closeConnection(conn);    
		}
		return found;
	}
	
	
	public ArrayList<UserModel> findByTeamId (int teamId) {
		
		Connection conn = null;
		ArrayList<UserModel> userList = new ArrayList<UserModel>();
			
		try{
				
			conn = DbUtils.createConnection();
			
			Statement cmd = conn.createStatement();
			String sql = "select * from user where team_id= " + teamId;

			ResultSet res = cmd.executeQuery(sql);

			while (res.next()) {				
				UserModel foundUser = new UserModel();
				foundUser.setDepartmentId(res.getInt("department_id"));
				foundUser.setTeamId(res.getInt("team_id"));
				foundUser.setRoleId(res.getInt("role_id"));
				foundUser.setFirstname(res.getString("firstname"));
				foundUser.setLastname(res.getString("lastname"));
				foundUser.setUsername(res.getString("username"));
				foundUser.setPassword(res.getString("password"));				
				
				userList.add(foundUser);
			}
		}
		catch (Exception e) {

			System.err.println("Impossible to connect to Database");
			e.printStackTrace();

		} finally {
			 DbUtils.closeConnection(conn);    
		}
		return userList;
	}
	
	
	public void deleteUser(int id) {
		Connection conn = null;
					
		try{
				
			conn =DbUtils.createConnection();
			
			Statement cmd = conn.createStatement();
			String sql = "delete from user where id= " +id;

			cmd.executeUpdate(sql);			
            
        }
        catch (Exception e){
           
        	System.err.println ("Impossible to connect to Database");
        	 e.printStackTrace();            
        }
        finally {
           DbUtils.closeConnection(conn);         
        }

	}
	
	public void updateUser(int id, UserModel userToUpdate) { 		
		
		Connection conn =null;
		
		try{
			conn =DbUtils.createConnection();
            
			//"update CD set id = , name = ?, photo = ?, age = ?, gender = ?, physical_activity = ? where id = ?"
            Statement cmd = conn.createStatement();	
            
	        String sql = "update user set "
	        		+ "department_id= "+userToUpdate.getDepartmentId()+" , "
	        		+ "team_id= "+userToUpdate.getTeamId()+" , "
	        		+ "role_id= "+userToUpdate.getRoleId()+" , "
	        		+ "firstname= '"+userToUpdate.getFirstname()+"' , "
	        		+ "lastname= '"+userToUpdate.getLastname()+"' , "
	        		+ "username= '"+userToUpdate.getUsername()+"' , "
	        		+ "password= '"+userToUpdate.getPassword()+"' "
	        		+ "where id= " +id;
	        		//+userToUpdate.getId()+" ";
	        		
	        int rowsUpdated = cmd.executeUpdate(sql);
	        
	        System.out.println("Updated "+rowsUpdated+ "rows in User Table");	                
            
        }
        catch (Exception e){
           
        	System.err.println ("Impossible to connect to Database");
        	 e.printStackTrace();            
        }
        finally {
           DbUtils.closeConnection(conn);         
        }

	}
	
	private static BasicDataSource getDataSource() {
		
	    BasicDataSource ds = new BasicDataSource();
	    ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/cid");
        ds.setUsername("root");
        ds.setPassword("tere");  
        ds.setMinIdle(5);
        ds.setMaxIdle(10);
        ds.setMaxOpenPreparedStatements(100); 
        return ds;      
}

}
