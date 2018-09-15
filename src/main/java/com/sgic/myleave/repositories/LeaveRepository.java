package com.sgic.myleave.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.myleave.entity.Leave;

public interface LeaveRepository extends JpaRepository<Leave, Long>{
	
	
	
}
