package com.sgic.myleave.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.myleave.entity.LeaveRequest;
import com.sgic.myleave.service.LeaveRequestService;

@RestController
public class LeaveRequestController {

	@Autowired
	private LeaveRequestService leaveRequestService;

	@GetMapping("/leaveRequest")
	public ResponseEntity<List<LeaveRequest>> getLeaveRequest(
			@RequestParam(value = "userName", required = false) String userName,
			@RequestParam(value = "leaveAllocation", required = false) Integer leaveAllocation) {

		if (userName == null && leaveAllocation == null) {
			ResponseEntity<List<LeaveRequest>> response = new ResponseEntity<>(
					leaveRequestService.getAllLeaveRequests(), HttpStatus.OK);
			return response;
		} else {
			List<LeaveRequest> FoundUser = leaveRequestService.findByUserNameAndAllocation(userName, leaveAllocation);
			if (!FoundUser.isEmpty()) {
				ResponseEntity<List<LeaveRequest>> response = new ResponseEntity<>(FoundUser, HttpStatus.OK);
				return response;
			} else {
				// How to Pass message with List?
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

			}
		}
	}
	
	@PostMapping("/leaveRequest")
	public HttpStatus createLeaveRequest(@Valid @RequestBody LeaveRequest leaveRequest) {
		boolean test = leaveRequestService.saveLeaveRequest(leaveRequest);
		if (test) {
			return HttpStatus.CREATED;
		} else {
			return HttpStatus.BAD_REQUEST;
		}
	}
	
}