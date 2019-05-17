package com.sgic.hrm.commons.dto.mapper;

import java.util.ArrayList;
import java.util.List;
import com.sgic.hrm.commons.dto.LeaveRequestData;
import com.sgic.hrm.commons.entity.LeaveRequest;

public class LeaveRequestDataToLeaveRequest {


  public static LeaveRequest mapToLeaveRequest(LeaveRequestData leaveRequestData) {
    LeaveRequest leaveRequest = new LeaveRequest();

    if (leaveRequestData != null) {
      leaveRequest.setId(leaveRequestData.getId());
      leaveRequest.setUser(UserDataToUser.mapToUser(leaveRequestData.getUser()));
      leaveRequest.setLeaveAllocation(LeaveAllocationDataToLeaveAllocation
          .mapToLeaveAllocation(leaveRequestData.getLeaveAllocation()));
      leaveRequest.setStartDate(leaveRequestData.getStartDate());
      leaveRequest.setEndDate(leaveRequestData.getEndDate());
      leaveRequest.setAttachment(leaveRequestData.getAttachment());
      leaveRequest.setReason(leaveRequestData.getReason());
      leaveRequest.setStatus(leaveRequestData.getStatus());
      leaveRequest.setNoOfDays(leaveRequestData.getNoOfDays());
    }
    return leaveRequest;
  }

  public static List<LeaveRequest> mapToLeaveRequestList(
      List<LeaveRequestData> leaveRequestDataList) {
    List<LeaveRequest> leaveRequestList = new ArrayList<LeaveRequest>();

    if (leaveRequestDataList != null) {
      for (LeaveRequestData leaveRequestData : leaveRequestDataList) {
        leaveRequestList.add(mapToLeaveRequest(leaveRequestData));
      }
    }
    return leaveRequestList;
  }
}
