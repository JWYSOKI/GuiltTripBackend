package com.guilttrip.service;

import java.util.List;

import com.guilttrip.entitymodel.User;

public interface UserService {

	User createUser(User user);

	int deleteUserById(int id);

	User findById(int id);

	User updateUser(User user);

	List<User> findAllUsers();

}
