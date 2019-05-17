package com.sgic.hrm.commons.dto.mapper;

import java.util.ArrayList;
import java.util.List;
import com.sgic.hrm.commons.dto.AcceptLeaveRequestData;
import com.sgic.hrm.commons.entity.AcceptLeaveRequest;

public class AcceptLeaveRequestDataToAcceptLeaveRequest {

  public static AcceptLeaveRequest mapToAcceptLeaveRequest(
      AcceptLeaveRequestData acceptLeaveRequestData) {
    AcceptLeaveRequest acceptLeaveRequest = new AcceptLeaveRequest();
    if (acceptLeaveRequestData != null) {
      acceptLeaveRequest.setId(acceptLeaveRequestData.getId());
      acceptLeaveRequest
          .setAcceptedBy(UserDataToUser.mapToUser(acceptLeaveRequestData.getAcceptedBy()));
      acceptLeaveRequest.setLeaveRequest(LeaveRequestDataToLeaveRequest
          .mapToLeaveRequest(acceptLeaveRequestData.getLeaveRequest()));
    }
    return acceptLeaveRequest;
  }

  public static List<AcceptLeaveRequest> mapToAcceptLeaveRequest(
      List<AcceptLeaveRequestData> acceptLeaveRequestDataList) {
    List<AcceptLeaveRequest> acceptLeaveRequestList =
        new ArrayList<AcceptLeaveRequest>();
    if (acceptLeaveRequestDataList != null) {
      for (AcceptLeaveRequestData acceptLeaveRequestData : acceptLeaveRequestDataList) {
        acceptLeaveRequestList.add(mapToAcceptLeaveRequest(acceptLeaveRequestData));
      }
    }
    return acceptLeaveRequestList;
  }
}
