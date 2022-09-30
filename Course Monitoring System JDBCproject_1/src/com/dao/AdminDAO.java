package com.dao;

import com.BeanClass.Admin;
import com.BeanClass.Batch;
import com.BeanClass.Course;
import com.BeanClass.Faculty;
import com.exception.AdminException;

public interface AdminDAO {
	public Admin adminLogin(String username,String password) throws AdminException;
	public String adminRegistration(Admin admin);
	public String AllocateCourse(Course course);
	public String AllocateBatch(Batch batch);
	public String AllocateFaculty(Faculty faculty);
	
//	public void generateReport(String batchid,String cname,int fid,int nstudent,String bsd,String du,String fname,String mobile);
	public void generateReport();
}
