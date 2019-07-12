package com.guilttrip.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guilttrip.entitymodel.User;
import com.guilttrip.service.UserService;

@RequestMapping("user")
@RestController
public class UserRestController {

	@Autowired
	private UserService service;

	List<User> users = new ArrayList<User>();

	@GetMapping
	public ResponseEntity<List<User>> findAllUsers() {
		List<User> allUsers = service.findAllUsers();
		if (allUsers.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<User>>(allUsers, HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id) {
		User getUser = service.findById(id);
		System.out.println(getUser);
		return new ResponseEntity<>(getUser, HttpStatus.OK);
	}

//CREATES USER
	@PostMapping
	public ResponseEntity<?> postUser(@RequestBody User user) {
		System.out.println(user);
		return new ResponseEntity<>(service.createUser(user), HttpStatus.OK);
	}

//UPDATES USER	
	@PutMapping
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		User updatedUser = service.updateUser(user);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}

//DELETES USER
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteUserById(@PathVariable int id) {
		int deleteUser = service.deleteUserById(id);
		return new ResponseEntity<>(deleteUser, HttpStatus.OK);
	}

}
