package it.polito.tdp.corsi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	
	private static String jdbcUrl="jdbc:mysql://localhost/iscritticorsi?useTimezone=true&serverTimezone=UTC&user=root&password=alessio";

	public static Connection getConnection() {

		Connection conn;
		
		
		try {
			conn = DriverManager.getConnection(jdbcUrl);
			return conn;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
