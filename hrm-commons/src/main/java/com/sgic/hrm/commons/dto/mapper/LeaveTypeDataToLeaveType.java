package com.sgic.hrm.commons.dto.mapper;

import java.util.ArrayList;
import java.util.List;
import com.sgic.hrm.commons.dto.LeaveTypeData;
import com.sgic.hrm.commons.entity.LeaveType;

public class LeaveTypeDataToLeaveType {

	
  public LeaveTypeDataToLeaveType() {

	}

public static LeaveType mapToLeaveType(LeaveTypeData leaveTypeData) {
    LeaveType leaveType = new LeaveType();

    if (leaveTypeData != null) {
      leaveType.setId(leaveTypeData.getId());
      leaveType.setLeaveTypeValue(leaveTypeData.getLeaveTypeValue());
      leaveType.setDefaultAllocation(leaveTypeData.getDefaultAllocation());
    }
    return leaveType;
  }

  public static List<LeaveType> mapToLeaveTypeDataList(List<LeaveTypeData> leaveTypeDataList) {
    List<LeaveType> leaveTypeList = new ArrayList<LeaveType>();

    if (leaveTypeDataList != null) {
      for (LeaveTypeData leaveTypeData : leaveTypeDataList) {
        leaveTypeList.add(mapToLeaveType(leaveTypeData));
      }
    }
    return leaveTypeList;
  }
}
