package com.sgic.hrm.lms.service;

import java.util.List;

import com.sgic.hrm.commons.entity.RejectLeaveRequest;

public interface RejectLeaveRequestService {

	  boolean addRejectLeaveRequest(RejectLeaveRequest rejectLeaveRequest);
	  boolean editRejectLeaveRequest(Integer id, RejectLeaveRequest rejectLeaveRequest);
	  List<RejectLeaveRequest> getAllRejectLeaveRequest();
	  RejectLeaveRequest getRejectLeaveRequest(Integer id);
	  boolean deleteRejectLeaveRequest(Integer id);

}
