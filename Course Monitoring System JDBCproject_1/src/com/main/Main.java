package com.main;

import java.util.Scanner;

import com.dao.AdminDAO;
import com.dao.AdminDAOimpl;
import com.exception.AdminException;

public class Main {
	public static void main(String[] args)  {
		System.out.println("-----Welcome to Course Monitoring System----");
		System.out.println("For login to Admin enter 1 :");
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
			
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + id);
			
		}
	}
}
