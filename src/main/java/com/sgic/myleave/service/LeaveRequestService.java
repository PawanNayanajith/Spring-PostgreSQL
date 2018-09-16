package com.sgic.myleave.service;

import java.util.List;

import com.sgic.myleave.entity.LeaveRequest;

public interface LeaveRequestService {

	List<LeaveRequest> getAllLeaveRequests();

	List<LeaveRequest> findByUserNameAndAllocation(String name, Integer allocation);

}
