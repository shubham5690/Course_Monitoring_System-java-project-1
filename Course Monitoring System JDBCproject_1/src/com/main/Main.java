package com.main;

import java.util.Scanner;

import com.BeanClass.Admin;
import com.BeanClass.Course;
import com.BeanClass.Faculty;
import com.dao.AdminDAO;
import com.dao.AdminDAOimpl;
import com.dao.FacultyDAO;
import com.dao.FacultyDAOimpl;
import com.exception.AdminException;
import com.exception.FacultyException;

public class Main {
	public static void main(String[] args)  {
		Boolean flag=true;
		while(flag) {
		System.out.println("============================================");	
		System.out.println("-----Welcome to Course Monitoring System----"+"\n");
		System.out.println("For login to Admin enter 1 ");
		System.out.println("For Admin reistration enter 2 ");
		System.out.println("For Faculty registration enter 3 ");
		System.out.println("For login to Admin enter 4 ");
		System.out.println("============================================"+"\n");
		System.out.println("enter number from above option  :");
		Scanner input=new Scanner(System.in);
		
		int id=input.nextInt();
		
		switch (id) {
		case 1: {
			System.out.println("Enter username :");
			String username=input.next();
			System.out.println("Enter password :");
			String password=input.next();
			AdminDAO adminlogin=new AdminDAOimpl();
			try {
				adminlogin.adminLogin(username, password);
				System.out.println("login successfully...");
			} catch (AdminException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			
			
		}
		case 2:{
			System.out.println("-----Welcome to Course ----"+"\n");
			System.out.println("create courseID :");
			int ci=input.nextInt();
			System.out.println("create course name :");
			String cn=input.next();
			System.out.println("set fee :");
			int f=input.nextInt();
			System.out.println("create course discription in less than 30 char :");
			String cd=input.next();
			AdminDAO course=new AdminDAOimpl();
			
			System.out.println(course.AllocateCourse(new Course(ci,cn,f,cd)));
			
			
			
			break;
		}
		case 4:{
			System.out.println("Create username :");
			String username=input.next();
			System.out.println("Create password :");
			String password=input.next();
			AdminDAO ad=new AdminDAOimpl();
			
			System.out.println(ad.adminRegistration(new Admin(username,password)));
			break;
			
		}
		case 5:{
			
			System.out.println("Create facultyName :");
			String fname=input.next();
			System.out.println("Create facultyAddress :");
			String faddress=input.next();
			System.out.println("Create mobile :");
			String mobile=input.next();
			System.out.println("Create email :");
			String email=input.next();
			System.out.println("Create username :");
			String username=input.next();
			System.out.println("Create password :");
			String password=input.next();
			FacultyDAO faculty=new FacultyDAOimpl();
			
//			System.out.println(
//					faculty.facultyRegistration( fname,faddress,mobile,email,username,password));
//			System.out.println(
//					faculty.facultyRegistration(new Faculty(0,fname,faddress,mobile,email,username,password)));
//			break;
			
		}
		case 6:{
			System.out.println("Enter username :");
			String username=input.next();
			System.out.println("Enter password :");
			String password=input.next();
			FacultyDAO fd=new FacultyDAOimpl();
			try {
				fd.facultyLogin(username, password);
				System.out.println("login successfully...");
			} catch (FacultyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + id);
			
		}
	  }
	}
}
