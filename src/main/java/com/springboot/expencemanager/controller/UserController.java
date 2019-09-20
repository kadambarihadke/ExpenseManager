package com.springboot.expencemanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.expencemanager.dto.UserDto;
import com.springboot.expencemanager.exceptions.RecordNotFoundException;
import com.springboot.expencemanager.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * UserController class responsible for registration and login of user
 * Methods Maps to service layer
 * @author Kadambari
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	private static Logger logger = LogManager.getLogger();
	
	/**
	 * MethodName: addUser
	 * @param user  UserDto Object
	 * @return ResponseEntity having status code and userDto object
	 */
	@PostMapping("/registeration")
	public ResponseEntity<UserDto> addUser(@RequestBody UserDto user)
	{
		boolean result=userService.addUser(user);
		if(result==true)
			return new ResponseEntity<UserDto>(user , HttpStatus.ACCEPTED);
		else
			 return new ResponseEntity<UserDto>(user,HttpStatus.NOT_FOUND);
	}
	
	/**
	 * MethodName:loginUser
	 * @param user UserDto Object
	 * @return ResponseEntity having status code and UserDto object
	 * @throws RecordNotFoundException for user not already registered
	 */
	@PostMapping("/login")
	public ResponseEntity<UserDto> loginUser(@RequestBody UserDto user) throws 
                                                                          RecordNotFoundException
	{
		logger.info("Username: "+ user.getUsername());
		logger.debug("Password: "+ user.getPassword());
		 String result=userService.loginUser(user);
		 if(result=="sucess") {
			 logger.info("Login is sucessful");
			 return new ResponseEntity<UserDto>(user , HttpStatus.ACCEPTED);}
		 else {
			 logger.info("Login is unsucessful");
			 return new ResponseEntity<UserDto>(user,HttpStatus.NOT_FOUND);
		 }
	}
}
