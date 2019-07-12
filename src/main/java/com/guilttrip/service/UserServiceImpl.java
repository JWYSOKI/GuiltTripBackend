package com.guilttrip.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guilttrip.dao.UserDao;
import com.guilttrip.entitymodel.User;

import javassist.bytecode.stackmap.TypeData.ClassName;


@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	private static final Logger LOGGER = Logger.getLogger( ClassName.class.getName() );

	@Autowired
	private UserDao dao;

	public User createUser(User user) {
		return dao.persist(user);
	}

	public User updateUser(User user) {
		return dao.updateUser(user);
	}

	public int deleteUserById(int id) {

		int numOfUsersDeleted = dao.deleteUserById(id);
		
		if (numOfUsersDeleted == 0) {
			System.out.println("There is no user with this id to delete.");
		}

		else if (numOfUsersDeleted == 1) {
			System.out.println("User has been successfully deleted.");

		}

		return numOfUsersDeleted;

	}

	public User findById(int id) {
		return dao.findById(id);
	}

	public List<User> findAllUsers() {
		return dao.findAllUsers();
	}

}
