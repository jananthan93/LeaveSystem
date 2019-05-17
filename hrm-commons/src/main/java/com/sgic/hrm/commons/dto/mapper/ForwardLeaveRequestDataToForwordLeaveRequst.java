package com.sgic.hrm.commons.dto.mapper;

import java.util.ArrayList;
import java.util.List;
import com.sgic.hrm.commons.dto.ForwardLeaveRequestData;
import com.sgic.hrm.commons.entity.ForwardLeaveRequest;

public class ForwardLeaveRequestDataToForwordLeaveRequst {

  public static ForwardLeaveRequest mapToForwardLeaveRequest(
      ForwardLeaveRequestData forwardLeaveRequestData) {

    ForwardLeaveRequest forwardLeaveRequest = new ForwardLeaveRequest();

    if (forwardLeaveRequestData != null) {
      forwardLeaveRequest.setId(forwardLeaveRequestData.getId());
      forwardLeaveRequest.setLeaveRequest(LeaveRequestDataToLeaveRequest
          .mapToLeaveRequest(forwardLeaveRequestData.getLeaveRequest()));
      forwardLeaveRequest
          .setForwardTo(UserDataToUser.mapToUser(forwardLeaveRequestData.getForwardTo()));
    }
    return forwardLeaveRequest;
  }

  public static List<ForwardLeaveRequest> mapToForwardLeaveRequestList(
      List<ForwardLeaveRequestData> forwardLeaveRequestDataList) {
    List<ForwardLeaveRequest> forwardLeaveRequestList = new ArrayList<ForwardLeaveRequest>();

    if (forwardLeaveRequestDataList != null) {
      for (ForwardLeaveRequestData forwardLeaveRequestData : forwardLeaveRequestDataList) {
        forwardLeaveRequestList.add(mapToForwardLeaveRequest(forwardLeaveRequestData));
      }
    }
    return forwardLeaveRequestList;
  }
}
