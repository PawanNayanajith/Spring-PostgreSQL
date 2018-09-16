package com.sgic.myleave.service;

import com.sgic.myleave.criteria.UserCriteria;
import com.sgic.myleave.entity.QUser;
import com.sgic.myleave.entity.User;
import com.sgic.myleave.repositories.UserRepository;

import com.querydsl.core.BooleanBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	// private List<User> users = new ArrayList<>();

	@Override
	public boolean saveUser(User user) {
		userRepository.save(user);
		return true;
	}

	@Override
	public boolean updateUser(User user, Long id) {
		User userToUpdate = userRepository.getOne(id);
		// to do
		userRepository.save(userToUpdate);
		return true;
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> getOneUser(Long id) {
		return userRepository.findById(id);

	}

	@Override
	public List<User> getOneUserByName(String name) {
		return userRepository.findByName(name);

	}

	@Override
	public boolean deleteUser(Long id) {
		userRepository.deleteById(id);
		return true;
	}

	@Override
	public List<User> search(UserCriteria userCriteria) {
		List<User> users = new ArrayList<>();
		BooleanBuilder booleanBuilder =new BooleanBuilder();
		if (userCriteria.getLeaveAllocation() != null) {
			booleanBuilder.and(QUser.user.leaveRequest.any().leave.allocation.eq(userCriteria.getLeaveAllocation()));
		}
		if (userCriteria.getLeaveName() != null) {
			booleanBuilder.and(QUser.user.leaveRequest.any().leave.leaveName.containsIgnoreCase(userCriteria.getLeaveName()));
		}

		if (userCriteria.getTelephone() != null) {
			booleanBuilder.and(QUser.user.telephone.containsIgnoreCase(userCriteria.getTelephone()));
		}

		if (userCriteria.getUserName() != null) {
			booleanBuilder.and(QUser.user.name.containsIgnoreCase(userCriteria.getUserName()));
		}

		if (booleanBuilder.hasValue()) {
			userRepository.findAll(booleanBuilder).forEach(users::add);
		} else {
			users = userRepository.findAll();
		}
		return users;

	}

}
