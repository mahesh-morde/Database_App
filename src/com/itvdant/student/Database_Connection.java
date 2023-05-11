package com.itvdant.student;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database_Connection {
	
	static Connection con = null;
	
	public static Connection getConnection() {
		
	try {
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/JAVA";
		String username = "root";
		String passward = "";
		
		con = DriverManager.getConnection(url,username,passward);
		
	}catch(Exception e){
		e.printStackTrace();
		
	}return con;
	}
	
	public static void closeConnection() {
		try {
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
