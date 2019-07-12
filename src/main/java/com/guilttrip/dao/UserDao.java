package com.guilttrip.dao;

import java.util.List;

import com.guilttrip.entitymodel.User;

public interface UserDao {

	User updateUser(User user);

	User findById(int id);

	int deleteUserById(int id);

	User persist(User user);

	List<User> findAllUsers();

}
