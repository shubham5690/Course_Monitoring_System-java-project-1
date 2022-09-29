package com.JDBCconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BuildConn {
	public static Connection provideConnection(){
		Connection connection=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url="jdbc:mysql://localhost:3306/Project1_cms";
		try {
			connection=DriverManager.getConnection(url, "root", "5690harsh");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
}
