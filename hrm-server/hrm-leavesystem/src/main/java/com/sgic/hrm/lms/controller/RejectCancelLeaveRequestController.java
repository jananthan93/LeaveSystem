package com.sgic.hrm.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.hrm.commons.dto.RejectCancelRequestData;
import com.sgic.hrm.commons.entity.mapper.RejectCancelRequestToRejectCancelRequestData;
import com.sgic.hrm.lms.service.RejectCancelRequestService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/rejectCancel")
public class RejectCancelLeaveRequestController {
	@Autowired
	RejectCancelRequestService rejectCancelRequestService;
	
	@GetMapping("leaverequest/{lId}")
	public RejectCancelRequestData getRejectCancelRequestByLeveRequestId(@PathVariable Integer lId) {
		return RejectCancelRequestToRejectCancelRequestData.mapToRejectCancelRequestData(rejectCancelRequestService
				.getRejectCancelRequestByLeaveRequest(lId));
	}
	
}
