package com.dao;

import com.BeanClass.Admin;
import com.exception.AdminException;

public interface AdminDAO {
	public Admin adminLogin(String username,String password) throws AdminException;
	public String adminRegistration(Admin admin);
	
}
