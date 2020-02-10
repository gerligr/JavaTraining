package course.jse.jdbc.lab;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import course.jse.jdbc.utils.DbUtils;

public class CdDao {

	
	public void saveCd (Cd newCd) {
	
        Connection conn =null;
        			
		try{
			conn =DbUtils.createConnection();
            
         
            Statement cmd = conn.createStatement ();	 		
	        String sql = "INSERT INTO `cd` "
	        		+ "( `Artist`, " 
	        		+ "`Company`, "
	        		+ "`Price`, "
	        		+ "`Title`, "
	        		+ "`Country`, "
	        		+ "`Year`, "
	        		+ "`Quantity`, "
	        		+ "`Version`) "
	        		+ "VALUES("
	        		+ "'"+newCd.getArtist()+"', "
	        		+ "'"+newCd.getCompany()+"', "
	        		+ newCd.getPrice()+", "	        		
					+ "'"+newCd.getTitle()+"', "				
					+ "'"+newCd.getCountry()+"', "
					+ newCd.getYear()+", "
					+ newCd.getQuantity()+", "		
					+ newCd.getVersion()+") ";	
	        
	        System.out.println(sql);
	        	        
	        int rowsUpdated =cmd.executeUpdate(sql);
	        
	        System.out.println("Updated "+rowsUpdated+ "rows in Cd Table");
            
        }
        catch (Exception e){
           
        	System.err.println ("Impossible to connect to Database");
        	 e.printStackTrace();            
        }
        finally {
           DbUtils.closeConnection(conn);         
        }

	}
	
	
	
	public Cd findById (Long id) {
		Connection conn = null;
		Cd found = null;
			
		try{
				
			conn =DbUtils.createConnection();
			
			Statement cmd = conn.createStatement();
			String sql = "select * from cd where id= " + id;

			ResultSet res = cmd.executeQuery(sql);

			if (res.next()) {
				
				found = new Cd();
				found.setArtist(res.getString("Artist"));
				found.setCompany(res.getString("company"));
				found.setCountry(res.getString("country"));
				found.setId(res.getLong("id"));
				found.setPrice(res.getDouble("price"));
				found.setQuantity(res.getInt("quantity"));
				found.setTitle(res.getString("title"));
				found.setVersion(res.getLong("version"));
				found.setYear(res.getInt("year"));
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
	
	public void deleteCd(Long id) {
		Connection conn = null;		
			
		try{
				
			conn =DbUtils.createConnection();
			
			Statement cmd = conn.createStatement();
			String sql = "delete from cd where id= " +id;

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
		
}
		



	
		
		
		
		
		
		
	
	

