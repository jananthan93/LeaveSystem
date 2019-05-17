package com.sgic.hrm.commons.dto.mapper;

import java.util.ArrayList;
import java.util.List;
import com.sgic.hrm.commons.dto.LeaveAllocationData;
import com.sgic.hrm.commons.entity.LeaveAllocation;

public class LeaveAllocationDataToLeaveAllocation {

  public static LeaveAllocation mapToLeaveAllocation(LeaveAllocationData leaveAllocationData) {
    LeaveAllocation leaveAllocation = new LeaveAllocation();
    if (leaveAllocationData != null) {
      leaveAllocation.setId(leaveAllocationData.getId());
      leaveAllocation.setAllocatedDays(leaveAllocationData.getAllocatedDays());
      leaveAllocation.setUtilizedDays(leaveAllocationData.getUtilizedDays());
      leaveAllocation.setUser(UserDataToUser.mapToUser(leaveAllocationData.getUser()));
      leaveAllocation.setLeaveType(
          LeaveTypeDataToLeaveType.mapToLeaveType(leaveAllocationData.getLeaveType()));
    }
    return leaveAllocation;
  }

  public static List<LeaveAllocation> mapToLeaveAllocationList(
      List<LeaveAllocationData> leaveAllocationDataList) {
    List<LeaveAllocation> leaveAllocationList = new ArrayList<LeaveAllocation>();

    if (leaveAllocationDataList != null) {
      for (LeaveAllocationData leaveAllocationData : leaveAllocationDataList) {
        leaveAllocationList.add(mapToLeaveAllocation(leaveAllocationData));
      }
    }
    return leaveAllocationList;
  }
}
