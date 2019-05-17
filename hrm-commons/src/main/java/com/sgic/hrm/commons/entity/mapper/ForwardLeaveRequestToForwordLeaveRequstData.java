package com.sgic.hrm.commons.entity.mapper;

import com.sgic.hrm.commons.dto.ForwardLeaveRequestData;
import com.sgic.hrm.commons.entity.ForwardLeaveRequest;
import java.util.ArrayList;
import java.util.List;

public class ForwardLeaveRequestToForwordLeaveRequstData {

  public static ForwardLeaveRequestData mapToForwardLeaveRequestData(
      ForwardLeaveRequest forwardLeaveRequest) {

    ForwardLeaveRequestData forwardLeaveRequestData = new ForwardLeaveRequestData();

    if (forwardLeaveRequest != null) {
      forwardLeaveRequestData.setId(forwardLeaveRequest.getId());
      forwardLeaveRequestData.setLeaveRequest(LeaveRequestToLeaveRequestData
          .mapToLeaveRequestData(forwardLeaveRequest.getLeaveRequest()));
      forwardLeaveRequestData
          .setForwardTo(UserToUserData.mapToUserData(forwardLeaveRequest.getForwardTo()));
    }
    return forwardLeaveRequestData;
  }

  public static List<ForwardLeaveRequestData> mapToForwardLeaveRequestDataList(
      List<ForwardLeaveRequest> forwardLeaveRequestList) {
    List<ForwardLeaveRequestData> forwardLeaveRequestDataList =
        new ArrayList<ForwardLeaveRequestData>();

    if (forwardLeaveRequestList != null) {
      for (ForwardLeaveRequest forwardLeaveRequest : forwardLeaveRequestList) {
        forwardLeaveRequestDataList.add(mapToForwardLeaveRequestData(forwardLeaveRequest));
      }
    }
    return forwardLeaveRequestDataList;
  }
}
