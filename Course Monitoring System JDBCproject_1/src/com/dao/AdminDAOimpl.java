package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.BeanClass.Admin;
import com.JDBCconnection.BuildConn;

import com.exception.AdminException;
import com.mysql.cj.protocol.Message;


public class AdminDAOimpl implements AdminDAO{

	@Override
	public Admin adminLogin(String username, String password) throws AdminException {
		
		 Admin adminlogin=null;
		 try(Connection connection=BuildConn.provideConnection()) {
			 PreparedStatement ps=connection.prepareStatement
					 ("select * from admin where username=? and password=?");
			 ps.setString(1, username);
			 ps.setString(2, password);
			 
			 ResultSet rs= ps.executeQuery();
			 if(rs.next()) {
					
					String n= rs.getString("username");
					String p= rs.getString("password");
					
					adminlogin=new Admin(n, p); 
			 }else {
				 throw new AdminException("Invalid Username or password..");
			 }
					
		} catch (SQLException e) {
			// TODO: handle exception
			throw new AdminException(e.getMessage());
		}
		 
		 
		 
		 
		 return adminlogin;
	}

	@Override
	public String adminRegistration(Admin admin) {
		String message="data not inserted...";
		try(Connection connection=BuildConn.provideConnection()) {
			PreparedStatement ps=connection.prepareStatement
					 ("insert into admin values(?,?)");
			 ps.setString(1, admin.getUsername());
			 ps.setString(2, admin.getPassword());
			 
			int x= ps.executeUpdate();
			if(x>0) {
				message="registration succesfully";
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			message=e.getMessage();
		}
		
		return message;
	}

	

}
