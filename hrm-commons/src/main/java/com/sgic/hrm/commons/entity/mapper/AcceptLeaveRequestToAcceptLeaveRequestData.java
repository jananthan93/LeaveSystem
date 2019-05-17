package com.sgic.hrm.commons.entity.mapper;

import java.util.ArrayList;
import java.util.List;
import com.sgic.hrm.commons.dto.AcceptLeaveRequestData;
import com.sgic.hrm.commons.entity.AcceptLeaveRequest;

public class AcceptLeaveRequestToAcceptLeaveRequestData {

  public static AcceptLeaveRequestData mapToAcceptLeaveRequestData(
      AcceptLeaveRequest acceptLeaveRequest) {
    AcceptLeaveRequestData acceptLeaveRequestData = new AcceptLeaveRequestData();
    if (acceptLeaveRequest != null) {
      acceptLeaveRequestData.setId(acceptLeaveRequest.getId());
      acceptLeaveRequestData
          .setAcceptedBy(UserToUserData.mapToUserData(acceptLeaveRequest.getAcceptedBy()));
      acceptLeaveRequestData.setLeaveRequest(LeaveRequestToLeaveRequestData
          .mapToLeaveRequestData(acceptLeaveRequest.getLeaveRequest()));
    }
    return acceptLeaveRequestData;
  }

  public static List<AcceptLeaveRequestData> mapToAcceptLeaveRequestData(
      List<AcceptLeaveRequest> acceptLeaveRequestList) {
    List<AcceptLeaveRequestData> acceptLeaveRequestDataList =
        new ArrayList<AcceptLeaveRequestData>();
    if (acceptLeaveRequestList != null) {
      for (AcceptLeaveRequest acceptLeaveRequest : acceptLeaveRequestList) {
        acceptLeaveRequestDataList.add(mapToAcceptLeaveRequestData(acceptLeaveRequest));
      }
    }
    return acceptLeaveRequestDataList;
  }
}
