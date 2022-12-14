package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.BeanClass.Admin;
import com.BeanClass.Batch;
import com.BeanClass.Course;
import com.BeanClass.Faculty;
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

	@Override
	public String AllocateFaculty(Faculty faculty) {
		// TODO Auto-generated method stub
		
			String message="data not inserted...";
			try(Connection connection=BuildConn.provideConnection()) {
				PreparedStatement ps=connection.prepareStatement
						 ("insert into Faculty values(?,?,?,?,?,?,?)");
				 ps.setInt(1, faculty.getFacultyid());
				 ps.setString(2, faculty.getFacultyname());
				 ps.setString(3, faculty.getFacultyaddress());
				 ps.setString(4, faculty.getMobile());
				 ps.setString(5, faculty.getEmail());
				 ps.setString(6, faculty.getUsername());
				 ps.setString(7, faculty.getPassword());
			 
				int x= ps.executeUpdate();
				if(x>0) {
					message="Allocated batches to faculty succesfully";
				}
				
			} catch (SQLException e) {
				// TODO: handle exception
				message=e.getMessage();
			}
			
			return message;
		
	}

	@Override
	public String AllocateCourse(Course course) {
		String message="data not inserted...";
		try(Connection connection=BuildConn.provideConnection()) {
			PreparedStatement ps=connection.prepareStatement
					 ("insert into course values(?,?,?,?)");
			 
			 ps.setInt(1, course.getCourseid());
			 ps.setString(2, course.getCoursename());
			 ps.setInt(3, course.getFee());
			 ps.setString(4, course.getCoursedescription());
			 
		 
			int x= ps.executeUpdate();
			if(x>0) {
				message="course allocated succesfully";
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			message=e.getMessage();
		}
		
		return message;
		
		
	}

	@Override
	public String AllocateBatch(Batch batch) {
		// TODO Auto-generated method stub
		String message="data not inserted...";
		try(Connection connection=BuildConn.provideConnection()) {
			PreparedStatement ps=connection.prepareStatement
					 ("insert into batch values(?,?,?,?,?,?)");
			 
			 ps.setInt(1, batch.getBatchid());
			 ps.setInt(2, batch.getCourseid());
			 ps.setInt(3, batch.getFacultyid());
			 
			 ps.setInt(4, batch.getNoOfStudent());
			 ps.setString(5, batch.getBatchStartDate());
			 ps.setString(6, batch.getDuration());
			 
		 
			int x= ps.executeUpdate();
			if(x>0) {
				message="Batch allocated succesfully";
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			message=e.getMessage();
		}
		
		return message;
		
	}

	@Override
	public void generateReport() {
try (Connection conn = BuildConn.provideConnection()){
			
			PreparedStatement ps= conn.prepareStatement
					("select c.coursename,b.batchid,b.facultyid,b.noofstudent,b.batchstartdate,b.duration,f.facultyname,f.mobile from course\r\n"
							+ "c inner join batch b inner join faculty f on c.courseid=b.courseid or b.facultyid=f.facultyid;");
			
			
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				
				String ca= rs.getString("coursename");
				int bid=rs.getInt("batchid");
				int fd=rs.getInt("facultyid");
				String fn= rs.getString("facultyname");
				String m= rs.getString("mobile");
				int nos=rs.getInt("noofstudent");
				String b= rs.getString("batchstartdate");
				String bd= rs.getString("duration");
				
				
				
				System.out.println("course name ="+ca);
				System.out.println("batchid ="+bid);
				System.out.println("facultyID ="+fd);
				System.out.println("faculty name ="+fn);
				System.out.println("mobile ="+m);
				System.out.println("no. of student="+nos);
				System.out.println("batch start date ="+b);
				System.out.println("batch duration ="+bd);
				
				System.out.println("=============================");
				
				
				
				
				
			}
			
			
			
			
			
			
		}catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		
	}

	

}
