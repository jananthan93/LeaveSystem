package com.sgic.hrm.commons.dto.mapper;

import java.util.ArrayList;
import java.util.List;
import com.sgic.hrm.commons.dto.AcceptCancelRequestData;
import com.sgic.hrm.commons.entity.AcceptCancelRequest;

public class AcceptCancelRequestDataToAcceptCancelRequest {

  public static AcceptCancelRequest mapToAcceptCancelRequest(
      AcceptCancelRequestData acceptCancelRequestData) {

    AcceptCancelRequest acceptCancelRequest = new AcceptCancelRequest();

    if (acceptCancelRequestData != null) {
      acceptCancelRequest.setId(acceptCancelRequestData.getId());
      acceptCancelRequest
          .setAcceptedBy(UserDataToUser.mapToUser(acceptCancelRequestData.getAcceptedBy()));
      acceptCancelRequest.setCancelLeaveRequest(CancelLeaveRequestDataToCancelLeaveRequest
          .mapToCancelLeaveRequest(acceptCancelRequestData.getCancelLeaveRequest()));
    }
    return acceptCancelRequest;
  }

  public static List<AcceptCancelRequest> mapToAcceptCancelRequestList(
      List<AcceptCancelRequestData> acceptCancelRequestDataList) {
    List<AcceptCancelRequest> acceptCancelRequestList = new ArrayList<AcceptCancelRequest>();

    if (acceptCancelRequestDataList != null) {
      for (AcceptCancelRequestData acceptCancelRequestData : acceptCancelRequestDataList) {
        acceptCancelRequestList.add(mapToAcceptCancelRequest(acceptCancelRequestData));
      }
    }
    return acceptCancelRequestList;
  }
}
