package com.sgic.myleave.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.myleave.entity.User;

public interface LeaveRequestRepository extends JpaRepository<User, Long>{
	
	
	
	
}