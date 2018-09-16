package com.sgic.myleave.controller;

import com.sgic.myleave.service.UserService;
import com.sgic.myleave.criteria.UserCriteria;
import com.sgic.myleave.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import javax.validation.Valid;

@RestController
public class UserController {

	@Autowired
	private UserService userservice;

	List<User> users = new ArrayList<>();

	@GetMapping("/users")
	public ResponseEntity<List<User>> getUser(@RequestParam(value = "userName", required = false) String userName) {
		if (userName == null) {
			ResponseEntity<List<User>> response = new ResponseEntity<>(userservice.getAllUsers(), HttpStatus.OK);
			return response;
		} else {
			List<User> FoundUser = userservice.getOneUserByName(userName);
			if (!FoundUser.isEmpty()) {
				ResponseEntity<List<User>> response = new ResponseEntity<>(FoundUser, HttpStatus.OK);
				return response;
			} else {
				// How to Pass message with List?
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}

		}
	}

	@GetMapping("/users/search")
	public ResponseEntity<List<User>> getUsers(UserCriteria userCriteria) {
		List<User> users = userservice.search(userCriteria);
		ResponseEntity<List<User>> response = new ResponseEntity<>(users, HttpStatus.OK);
		return response;
	}

	@PostMapping("/users")
	public HttpStatus createUsers(@Valid @RequestBody User user) {
		boolean test = userservice.saveUser(user);
		if (test) {
			return HttpStatus.CREATED;
		} else {
			return HttpStatus.BAD_REQUEST;
		}
	}

	@PutMapping("/users/{empId}")
	public HttpStatus editUsers(@RequestBody User user, @PathVariable("empId") Long id) {
		boolean test = userservice.updateUser(user, id);
		if (test) {
			return HttpStatus.OK;
		} else {
			return HttpStatus.BAD_REQUEST;
		}
	}

	@DeleteMapping("/users/{empId}")
	public HttpStatus deleteUsers(@PathVariable("empId") Long id) {
		boolean test = userservice.deleteUser(id);
		if (test) {
			return HttpStatus.OK;
		} else {
			return HttpStatus.BAD_REQUEST;
		}
	}
}