package com.sgic.hrm.commons.entity.mapper;

import java.util.ArrayList;
import java.util.List;
import com.sgic.hrm.commons.dto.LeaveRequestData;
import com.sgic.hrm.commons.entity.LeaveRequest;

public class LeaveRequestToLeaveRequestData {

  public static LeaveRequestData mapToLeaveRequestData(LeaveRequest leaveRequest) {
    LeaveRequestData leaveRequestData = new LeaveRequestData();

    if (leaveRequest != null) {
      leaveRequestData.setId(leaveRequest.getId());
      leaveRequestData.setAttachment(leaveRequest.getAttachment());
      leaveRequestData.setCreatedAt(leaveRequest.getCreatedAt());
      leaveRequestData.setStartDate(leaveRequest.getStartDate());
      leaveRequestData.setEndDate(leaveRequest.getEndDate());
      leaveRequestData.setReason(leaveRequest.getReason());
      leaveRequestData.setUpdatedAt(leaveRequest.getUpdatedAt());
      leaveRequestData.setUser(UserToUserData.mapToUserData(leaveRequest.getUser()));
      leaveRequestData.setFullName(UserToUserData.mapToUserData(leaveRequest.getUser()).getFullName());
      leaveRequestData.setLeaveAllocation(LeaveAllocationToLeaveAllocationData
          .mapToLeaveAllocationData(leaveRequest.getLeaveAllocation()));
      leaveRequestData.setLeaveTypeValue(LeaveAllocationToLeaveAllocationData
    		  .mapToLeaveAllocationData(leaveRequest.getLeaveAllocation()).getLeaveType().getLeaveTypeValue());
      leaveRequestData.setStatus(leaveRequest.getStatus());
      leaveRequestData.setNoOfDays(leaveRequest.getNoOfDays());
    }
    return leaveRequestData;
  }

  public static List<LeaveRequestData> mapLeaveRequestDataList(
      List<LeaveRequest> leaveRequestList) {
    List<LeaveRequestData> leaveRequestDataList = new ArrayList<LeaveRequestData>();

    if (leaveRequestList != null) {
      for (LeaveRequest leaveRequest : leaveRequestList) {
        leaveRequestDataList.add(mapToLeaveRequestData(leaveRequest));
      }
    }
    return leaveRequestDataList;
  }

}
