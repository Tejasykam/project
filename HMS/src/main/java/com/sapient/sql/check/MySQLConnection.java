package com.sapient.sql.check;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
	//static block is executed during class loading by JVM's Class Loader
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @returns Connection object
	 * @throws SQLException
	 * getConnection() is based factory design pattern which returns Connection object
	 */
	public static Connection getConnection() throws SQLException {
		return DriverManager
				.getConnection("jdbc:mysql://localhost:3306/hms","root","2518");

	}
}
