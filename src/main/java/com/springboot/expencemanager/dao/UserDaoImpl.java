package com.springboot.expencemanager.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.expencemanager.Entity.Expenses;
import com.springboot.expencemanager.Entity.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDAO {
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void addUser(User user) {
		entityManager.persist(user);
	}

	@Override
	public List<String> loginUser(User user) {
		Query query = entityManager.createQuery("select password from User where username = '"+user.getUsername()+"'");
		List<String> pwd = query.getResultList();
		return pwd;
		
	}
	
	public User findUser(int userId) {
		return entityManager.find(User.class, userId);
	}

	
	
}
