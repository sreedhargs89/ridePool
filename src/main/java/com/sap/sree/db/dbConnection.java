package com.sap.sree.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author I310383
 *
 */
public class dbConnection {
	
	@SuppressWarnings("javadoc")
	public static Connection getConnection() throws Exception{
		 
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
		}
		Connection connection = null;
		try {
			connection = DriverManager
			.getConnection("jdbc:mysql://localhost:3306/pool","root", "root");
	 
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}
	 
		return connection;
	}

}
