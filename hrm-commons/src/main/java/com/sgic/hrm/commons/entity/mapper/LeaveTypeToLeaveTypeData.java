package com.sgic.hrm.commons.entity.mapper;

import java.util.ArrayList;
import java.util.List;
import com.sgic.hrm.commons.dto.LeaveTypeData;
import com.sgic.hrm.commons.entity.LeaveType;

public class LeaveTypeToLeaveTypeData {
	
	public static LeaveTypeData mapToLeaveTypeData(LeaveType leaveType) {
		LeaveTypeData leaveTypeData = new LeaveTypeData();
		
		if(leaveType != null) {
			leaveTypeData.setId(leaveType.getId());
			leaveTypeData.setLeaveTypeValue(leaveType.getLeaveTypeValue());
			leaveTypeData.setDefaultAllocation(leaveType.getDefaultAllocation());
			leaveTypeData.setCreatedAt(leaveType.getCreatedAt());
			leaveTypeData.setUpdatedAt(leaveType.getUpdatedAt());
		}
		return leaveTypeData;
	}
	
  public static List<LeaveTypeData> mapToLeaveTypeDataList(List<LeaveType> leaveTypeList) {
    List<LeaveTypeData> leaveTypeDataList = new ArrayList<LeaveTypeData>();

    if (leaveTypeList != null) {
      for (LeaveType leaveType : leaveTypeList) {
        leaveTypeDataList.add(mapToLeaveTypeData(leaveType));
      }
    }
    return leaveTypeDataList;
  }

}
