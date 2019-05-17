package com.sgic.hrm.lms.service;

import java.util.List;

import com.sgic.hrm.commons.entity.AcceptLeaveRequest;

public interface AcceptLeaveRequestService {
	 boolean addAcceptLeaveRequest(AcceptLeaveRequest acceptLeaveRequest);
	  boolean editAcceptLeaveRequest(Integer id, AcceptLeaveRequest acceptLeaveRequest);
	  List<AcceptLeaveRequest> getAllAcceptLeaveRequests();
	  AcceptLeaveRequest getAcceptLeaveRequest(Integer id);
	  boolean deleteAcceptLeaveRequest(Integer id);

}
