package com.JDBCconnection;

import java.sql.Connection;

public class CheckConnection {
	public static void main(String[] args) {
		Connection connection=BuildConnection.buildConnection();
		System.out.println(connection);
	}
}
