package com.sgic.hrm.commons.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sgic.hrm.commons.entity.LeaveAllocation;
import com.sgic.hrm.commons.entity.LeaveType;
import com.sgic.hrm.commons.entity.User;

public interface LeaveAllocationRepository extends JpaRepository<LeaveAllocation, Integer> {

  List<LeaveAllocation> findAllByUserOrderByIdAsc(User user);
  
  LeaveAllocation findByUserAndLeaveType(User user, LeaveType leaveType);

}
