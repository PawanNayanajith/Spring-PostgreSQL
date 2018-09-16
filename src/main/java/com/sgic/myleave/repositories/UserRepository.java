package com.sgic.myleave.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.myleave.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findByName(String name);

}