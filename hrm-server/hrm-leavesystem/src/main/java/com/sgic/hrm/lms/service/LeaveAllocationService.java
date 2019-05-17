package com.sgic.hrm.lms.service;

import java.util.List;
import com.sgic.hrm.commons.entity.AppointmentType;
import com.sgic.hrm.commons.entity.CarryforwardRequest;
import com.sgic.hrm.commons.entity.LeaveAllocation;
import com.sgic.hrm.commons.entity.LeaveRequest;
import com.sgic.hrm.commons.entity.LeaveType;
import com.sgic.hrm.commons.entity.User;

public interface LeaveAllocationService {
  
  boolean allocateLeave(User user, AppointmentType appointmentType , List<LeaveType> leaveTypeList);

  List<LeaveAllocation> viewLeaveAllocationByUser(User user);

  boolean updateLeaveCount(LeaveRequest leaveRequest);
  
  void resetLeaveAllocationYearly();
  
  void resetLeaveAllocationMonthly();

  boolean deleteLeaveAllocation(Integer id);
  
  boolean deductCarryforwardedDays(CarryforwardRequest carryforwardRequest);
  
  LeaveAllocation getByUserAndType(User user);
}
