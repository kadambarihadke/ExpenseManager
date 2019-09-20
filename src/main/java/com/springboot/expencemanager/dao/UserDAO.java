package com.springboot.expencemanager.dao;

import java.util.List;

import com.springboot.expencemanager.Entity.Expenses;
import com.springboot.expencemanager.Entity.User;

public interface UserDAO {
	
	public void addUser(User user);
	/**
	 * 
	 * @param user
	 * @return Password for authentication of user
	 */
	public List<String> loginUser(User user);
}
