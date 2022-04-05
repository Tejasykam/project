package com.sapient.sql.check;

import java.sql.SQLException;

public class TestConnection {

	public static void main(String[] args) {
		try {
			if( MySQLConnection.getConnection() != null) {
				System.out.println("Connected to MySQL database");
			}else {
				System.out.println("Unbale to connect to MySQL database");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}


	}

}
