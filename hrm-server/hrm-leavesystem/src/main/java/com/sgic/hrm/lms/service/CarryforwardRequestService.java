package com.sgic.hrm.lms.service;

import java.util.List;

import com.sgic.hrm.commons.dto.CarryforwardObjectData;
import com.sgic.hrm.commons.entity.CarryforwardRequest;
import com.sgic.hrm.commons.enums.Status;

public interface CarryforwardRequestService {
	List<CarryforwardRequest> viewAllCarryforwardRequest();
	List<CarryforwardRequest> getCarryforwardRequestByStatus(Status status);
	boolean createCarryforwardRequest(CarryforwardObjectData carryforwardObjectData);
	boolean acceptCarryforwardRequest(String username, CarryforwardRequest carryforwardRequest);
	boolean rejectCarryforwardRequest(String username, CarryforwardRequest carryforwardRequest, String reason);
	CarryforwardRequest getByUsername(String username);
	List<CarryforwardRequest> getCarryforwardRequestByStatusAndUserName(String userName);
	
}
