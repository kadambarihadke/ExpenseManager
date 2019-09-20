package com.springboot.expencemanager.service;

import com.springboot.expencemanager.dto.UserDto;

public interface UserService {
	/**
	 * 
	 * @param userDto object
	 * @return String message 
	 */
	public String loginUser(UserDto user);

	/**
	 * 
	 * @param user 
	 * @return false if confirm password and password don't match
	 */
	public boolean addUser(UserDto user);
	
}
