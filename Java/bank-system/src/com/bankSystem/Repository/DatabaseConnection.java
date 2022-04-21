package com.bankSystem.Repository;

import java.sql.*;

public class DatabaseConnection {
	
	// static final String JDBC_DRIVER = "org.postgresql.Driver"; // JDBC Driver
	static final String DB_URL = "jdbc:postgresql://localhost:5432/bank_management_db"; // Database URL
	static final String USER = "postgres"; // Database user name
	static final String PASSWORD = "12345678"; // Database password
	
	Connection conn;
	Statement stmt;
	ResultSet result;
	
	public DatabaseConnection() {}
	
	public void openConnection() {	
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			stmt = conn.createStatement();		
			
		} catch (Exception e) {
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}
	
	public void closeConnection() {
		try {
			if (conn != null) conn.close();
			if (stmt != null) stmt.close();
			if (result != null) result.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
