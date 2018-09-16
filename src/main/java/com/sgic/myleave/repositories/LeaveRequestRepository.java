package com.sgic.myleave.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.sgic.myleave.entity.LeaveRequest;

public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long> {

	@Query("Select lr from LeaveRequest as lr where lr.user.name = ?1 and lr.leave.allocation = ?2")
	List<LeaveRequest> findByUserNameAndAllocation(String name, Integer allocation);

}