package com.main;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;
import java.util.Locale;
import java.util.Scanner;

import com.BeanClass.Admin;
import com.BeanClass.Batch;
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
		System.out.println("For Faculty login enter 3 ");
		System.out.println("For Generate Report for every batch enter 4 ");
		System.out.println("Exit from application enter 5 ");
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
			Boolean flag1=true;
			while(flag1) {
				
				System.out.println("allocate courses enter 1 ");
				System.out.println("allocate batches 2 ");
				System.out.println("allocate batches to faculty 3 ");
				System.out.println("exit from admin 4 ");
				System.out.println("enter number from above option  :");
				Scanner sc=new Scanner(System.in);
				int no=sc.nextInt();
				
				
				switch (no) {
				case 1: {
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
					System.out.println("data inserted successfully");
					break;
				}
				case 2:{
					
					System.out.println("-----Welcome to batches ----"+"\n");
					System.out.println("create batchID :");
					int bi=input.nextInt();
					System.out.println("enter course id that created in course :");
					int ci=input.nextInt();
					System.out.println("create faculty ID :");
					int f=input.nextInt();
					System.out.println("no. of student enrolled in a batch :");
					int ns=input.nextInt();
					System.out.println("set batch start date format in yyyy-MM-dd :");
					String date=input.next();
//					
					
					System.out.println("set duration of course :");
					String d=input.next();
					AdminDAO batch=new AdminDAOimpl();
					
					System.out.println(batch.AllocateBatch(new Batch(bi,ci,f,ns,date,d)));
					System.out.println("data inserted successfully");
					break;
					
				}
				case 3:{
					System.out.println("---allocate id  to the faculty according to courses and baches--");
					System.out.println("give authentic faculty id from batches :");
					int fid=input.nextInt();
					System.out.println("enter facultyName :");
					String fname=input.next();
					System.out.println("enter facultyAddress :");
					String faddress=input.next();
					System.out.println("enter mobile :");
					String mobile=input.next();
					System.out.println("enter email :");
					String email=input.next();
					System.out.println("Create username :");
					String name=input.next();
					System.out.println("Create password :");
					String pass=input.next();
					AdminDAO faculty=new AdminDAOimpl();
					
					faculty.AllocateFaculty(new Faculty(fid, fname,faddress,mobile,email,name,pass));
					System.out.println("data inserted successfully");
					break;
					
					
				}
				case 4:{
					flag1=false;
					System.out.println("exit from admin");
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + no);
				}
				
			}
			
			break;
			
			
		}
		case 2:{
			System.out.println("Create username :");
			String username=input.next();
			System.out.println("Create password :");
			String password=input.next();
			AdminDAO ad=new AdminDAOimpl();
			
			System.out.println(ad.adminRegistration(new Admin(username,password)));
			break;
		
		}
		case 3:{
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
			
			System.out.println("---your  details---------");
			FacultyDAO facultDetail=new FacultyDAOimpl();
			
			System.out.println(facultDetail.getFacultydata(username, password));
			break;
		
		}
		case 4:{
			System.out.println("======Report for every batch========");
			AdminDAO report=new AdminDAOimpl();
			report.generateReport();
			break;
			
		}
		case 5:{
			flag=false;
			System.out.println("successfully exit from application...");
			break;
			
		}
		case 6:{
			
			
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + id);
			
		}
	  }
	}
}
