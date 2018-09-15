package com.sgic.myleave.service;

import com.sgic.myleave.entity.User;
import com.sgic.myleave.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	private List<User> users = new ArrayList<>();

	@Override
	public boolean saveUser(User user) {
		userRepository.save(user);
		return true;
	}

	@Override
	public boolean updateUser(User user) {
		for (User existingUser : users) {
			if (existingUser.getId() == user.getId()) {
				existingUser.setName(user.getName());
				existingUser.setTelephone(user.getTelephone());
				return true;
			}
		}
		return false;
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public boolean deleteUser(Long id) {
		userRepository.deleteById(id);
		return true;
	}

}
