package com.sgic.hrm.lms.service;

import java.util.List;

import com.sgic.hrm.commons.entity.LeaveType;

public interface LeaveTypeService {
	
	boolean createLeaveType(LeaveType leaveType);
	List<LeaveType> viewAllLeaveType();
	boolean deleteLeaveType(Integer id);
	boolean updateLeaveType(Integer id,LeaveType leaveType);

}
