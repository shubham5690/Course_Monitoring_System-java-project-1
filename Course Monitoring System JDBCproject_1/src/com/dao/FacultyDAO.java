package com.dao;

import com.BeanClass.Admin;
import com.BeanClass.Faculty;
import com.exception.AdminException;
import com.exception.FacultyException;

public interface FacultyDAO {

	public String facultyRegistration(Faculty faculty);
	public Faculty facultyLogin(String username,String password) throws FacultyException;
}
