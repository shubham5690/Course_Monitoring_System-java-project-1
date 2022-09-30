package com.dao;

import java.util.List;

import com.BeanClass.Admin;
import com.BeanClass.Faculty;
import com.exception.AdminException;
import com.exception.FacultyException;
import com.masai.bean.StudentDTO;
import com.masai.exceptions.CourseException;

public interface FacultyDAO {


	public Faculty facultyLogin(String username,String password) throws FacultyException;
	public String getFacultydata(String username,String password);
}
