package com.bankSystem.Repository;

import java.sql.SQLException;
import com.bankSystem.Entity.User;
import com.bankSystem.Intefaces.IUser;

public class UserRepository implements IUser {
	
	DatabaseConnection dbConn;
	
	public UserRepository() {
		dbConn = new DatabaseConnection();
	}
	
	public int getUserId(String phone, String pass) throws SQLException {
		int id;
		String  sql = "SELECT id FROM public.user WHERE phone = '"+ phone +"' and password = '"+ pass +"';";
		
		dbConn.openConnection();
		dbConn.result = dbConn.stmt.executeQuery(sql);
		
		if (dbConn.result.next()) {
			id = dbConn.result.getInt("id");
		} else {
			id = -1;
		}
		
		dbConn.closeConnection();
		
		return id;
	}
	
	public void insertIntoDatabase(User user) {
		try {
			String sql = "INSERT INTO public.user (name, age, gender, nid_number, phone, password)"
					+ "values "
					+ "('"+user.getName()+"',"+user.getAge()+", '"+user.getGender()+"', "+user.getNidNumber()+", '"+user.getPhone()+"', '"+user.getPassword()+"');";
			
			dbConn.openConnection();
			dbConn.stmt.executeUpdate(sql);
			dbConn.closeConnection();
		} catch (SQLException e) {
			System.out.println("System exit due to wrong data => " + e.getMessage());
			System.exit(0);
		}
	}
	
	public void userInfo(int userId) throws SQLException {
		dbConn.openConnection();
		dbConn.result = dbConn.stmt.executeQuery("SELECT * FROM public.user WHERE id = " + userId + ";");
		dbConn.result.next();
		
		System.out.println("\nAccount Holder: " + dbConn.result.getString("name"));
		System.out.println("Age: " + dbConn.result.getInt("age"));
		System.out.println("Gender: " + dbConn.result.getString("gender"));
		System.out.println("Nid Number: " + dbConn.result.getInt("nid_number"));
		System.out.println("Phone Number: " + dbConn.result.getString("phone"));
		
		dbConn.closeConnection();
	}
}
