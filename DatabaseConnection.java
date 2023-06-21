package com.student;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	//load the driver
			//make the connection
			//create a statement object
			//exeute sql commands
			
		public static  String driver="com.mysql.cj.jdbc.Driver";
		public static	String url="jdbc:mysql://localhost:3306/Student";
		public static	String un="root";
		public static	String up="root";
		public static Connection conn;
		
		public static Connection getConnection() throws Exception {
			
			Class.forName(driver);
			conn=DriverManager.getConnection(url, un, up);
			if(conn==null) {
				System.out.println("Error in getting connection");
			}
			return conn;
			
		}
}