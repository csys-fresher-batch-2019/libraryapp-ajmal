package com.chainsys.libraryapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.chainsys.libraryapp.exception.DbException;

public class Connectionutil {
	public static Connection getConnection() throws DbException {
		Connection connection = null; 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
		} catch (ClassNotFoundException e) {	
			e.printStackTrace();
		}
		 
		 catch (SQLException e) {
			e.printStackTrace();
		}
			
			return connection;
		
	}

}
