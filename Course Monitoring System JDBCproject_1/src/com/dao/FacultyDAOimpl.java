package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.BeanClass.Admin;
import com.BeanClass.Faculty;
import com.JDBCconnection.BuildConn;
import com.exception.AdminException;
import com.exception.FacultyException;
import com.masai.bean.StudentDTO;
import com.masai.exceptions.CourseException;
import com.masai.utility.DBUtil;

public class FacultyDAOimpl implements FacultyDAO{


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

	@Override
	public String getFacultydata(String username,String password) {
		String message="data not found for this username";
		
		
		
		try (Connection conn = BuildConn.provideConnection()){
			
			PreparedStatement ps= conn.prepareStatement("select * from faculty where username=? and password=?");
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				
				int fid= rs.getInt("facultyid");
				String fn= rs.getString("facultyname");
				String fa= rs.getString("facultyaddress");
				
				String m= rs.getString("mobile");
				String e= rs.getString("email");
				String un= rs.getString("username");
				String p= rs.getString("password");
				
				System.out.println("facultyid ="+fid);
				System.out.println("facultyname ="+fn);
				System.out.println("facultyaddress ="+fa);
				System.out.println("mobile ="+m);
				System.out.println("email ="+e);
				System.out.println("username ="+un);
				System.out.println("password ="+p);
				
				System.out.println("=============================");
				
				message="here is the data";
				
				
				
			}
			
			
			
			
			
			
		}catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		
		
		
		return message;
	}

	

}
