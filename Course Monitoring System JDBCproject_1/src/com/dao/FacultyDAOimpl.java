package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.BeanClass.Admin;
import com.BeanClass.Faculty;
import com.JDBCconnection.BuildConn;
import com.exception.AdminException;
import com.exception.FacultyException;

public class FacultyDAOimpl implements FacultyDAO{

//	@Override
//	public String facultyRegistration(Faculty faculty) {
//		String message="data not inserted...";
//		try(Connection connection=BuildConn.provideConnection()) {
//			PreparedStatement ps=connection.prepareStatement
//					 ("insert into Faculty(facultyname,facultyaddress,mobile,email,username,password) values(?,?,?,?,?,?)");
//			 
//			 ps.setString(1, faculty.getFacultyname());
//			 ps.setString(2, faculty.getFacultyaddress());
//			 ps.setString(3, faculty.getMobile());
//			 ps.setString(4, faculty.getEmail());
//			 ps.setString(5, faculty.getUsername());
//			 ps.setString(6, faculty.getPassword());
//		 
//			int x= ps.executeUpdate();
//			if(x>0) {
//				message="registration succesfully";
//			}
//			
//		} catch (SQLException e) {
//			// TODO: handle exception
//			message=e.getMessage();
//		}
//		
//		return message;
//		
//	}

	@Override
	public Faculty facultyLogin(String username, String password) throws FacultyException {
		// TODO Auto-generated method stub
		Faculty flogin=null;
		 try(Connection connection=BuildConn.provideConnection()) {
			 PreparedStatement ps=connection.prepareStatement
					 ("select * from faculty where username=? and password=?");
			 ps.setString(1, username);
			 ps.setString(2, password);
			 
			 ResultSet rs= ps.executeQuery();
			 if(rs.next()) {
				 	int id= rs.getInt("facultyid");
					String n= rs.getString("facultyname");
					String a= rs.getString("facultyaddress");
					String m= rs.getString("mobile");
					String e= rs.getString("email");
					String un= rs.getString("username");
					String p= rs.getString("password");

					flogin=new Faculty(id,n,a,m,e,un,p);
			 }else {
				 throw new FacultyException("Invalid Username or password..");
			 }
					
		} catch (SQLException e) {
			// TODO: handle exception
			throw new FacultyException(e.getMessage());
		}
		 
		 
		 
		 
		 return flogin;
		
	}

	

}
