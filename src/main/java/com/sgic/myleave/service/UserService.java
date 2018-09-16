package com.sgic.myleave.service;

import com.sgic.myleave.criteria.UserCriteria;
import com.sgic.myleave.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
	
	boolean saveUser(User user);

	boolean updateUser(User user, Long id);

	List<User> getAllUsers();

	Optional<User> getOneUser(Long id);

	List<User> getOneUserByName(String name);
	
	boolean deleteUser(Long id);

	List<User> search(UserCriteria userCriteria);
}
