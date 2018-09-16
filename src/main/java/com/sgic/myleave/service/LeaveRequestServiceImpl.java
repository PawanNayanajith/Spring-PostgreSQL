package com.sgic.myleave.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.myleave.entity.LeaveRequest;
import com.sgic.myleave.repositories.LeaveRequestRepository;

@Service
public class LeaveRequestServiceImpl implements LeaveRequestService {

	@Autowired
	private LeaveRequestRepository leaveRequestRepository;

	@Override
	public List<LeaveRequest> getAllLeaveRequests() {
		return leaveRequestRepository.findAll();
	}

	@Override
	public List<LeaveRequest> findByUserNameAndAllocation(String name, Integer allocation) {
		return leaveRequestRepository.findByUserNameAndAllocation(name, allocation);

	}

	@Override
	public boolean saveLeaveRequest(LeaveRequest leaveRequest) {
		leaveRequestRepository.save(leaveRequest);
		return true;

	}

}
