package com.springboot.expencemanager.service;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.springboot.expencemanager.Conversion.ConversionInterface;
import com.springboot.expencemanager.Entity.User;
import com.springboot.expencemanager.dao.UserDAO;
import com.springboot.expencemanager.dto.UserDto;

/**
 * Description: Deals with user and performs conversion to Dto and Entity done as required
 * @author Kadambari
 *
 */
@Service
public class UserServiceImplement implements UserService,
                                          ConversionInterface<User, UserDto> {

	@Autowired
	private UserDAO userDAO;
	
	private static Logger logger = LogManager.getLogger();

	@Override
	public String loginUser(UserDto userDto) {
		User user=new User();
		translateToEntity(user, userDto);
		List<String> pwd=userDAO.loginUser(user);
		if(!pwd.isEmpty() && pwd.get(0).equals(userDto.getPassword()))
		{
			logger.info("Sucessfully Logged id "+ user.getUsername());
			return "sucess";
		}
		logger.info("Username or password enterd is incorrect "+ 
		              user.getUsername());
		return "unsucess";
	}
	
	@Transactional
	@Override
	public boolean addUser(UserDto userdto)
	{
		String password=userdto.getConfirmPassword();
		String confirmPass=userdto.getPassword();
		User user=new User();
		translateToEntity(user, userdto);
		//User user=modelMapper.map(userdto,User.class);
		if(password.equals(confirmPass)) {
			userDAO.addUser(user);
			logger.info("Password and confirm password matched for user"
			+userdto.getUsername());
			return true;
			}
		else 
			logger.info("Password and confirm password don't match");
			return false;
		
	}
	@Override
	public User translateToEntity(User entity, UserDto dto) {
		entity.setUsername(dto.getUsername());
		entity.setPassword(dto.getPassword());
		return entity;
	}
	@Override
	public UserDto translateToDTO(User entity, UserDto dto) {
		dto.setUsername(entity.getUsername());
		dto.setPassword(entity.getPassword());
		return dto;
	}

	@Override
	public List<UserDto> translateToDtos(List<User> entity) {
		// TODO Auto-generated method stub
		return null;
	}
}
