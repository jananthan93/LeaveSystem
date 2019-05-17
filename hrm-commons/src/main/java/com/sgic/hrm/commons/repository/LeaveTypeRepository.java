package com.sgic.hrm.commons.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sgic.hrm.commons.entity.LeaveType;

public interface LeaveTypeRepository extends JpaRepository<LeaveType, Integer>{

	LeaveType findByLeaveTypeValue(String leaveTypeValue);
}
