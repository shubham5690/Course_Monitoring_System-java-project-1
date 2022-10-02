package com.JDBCconnection;

import java.sql.Connection;

public class CheckConnection {
	public static void main(String[] args) {
		Connection connection=BuildConn.provideConnection();
		System.out.println(connection);
	}
}
