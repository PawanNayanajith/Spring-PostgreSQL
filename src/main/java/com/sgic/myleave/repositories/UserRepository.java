package com.sgic.myleave.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.sgic.myleave.entity.User;

public interface UserRepository extends JpaRepository<User, Long>, QuerydslPredicateExecutor<User>{

	List<User> findByName(String name);

}