package com.sgic.hrm.commons.entity.mapper;

import java.util.ArrayList;
import java.util.List;
import com.sgic.hrm.commons.dto.AcceptCancelRequestData;
import com.sgic.hrm.commons.entity.AcceptCancelRequest;

public class AcceptCancelRequestToAcceptCancelRequestData {

  public static AcceptCancelRequestData mapToAcceptCancelRequestData(
      AcceptCancelRequest acceptCancelRequest) {
    AcceptCancelRequestData acceptCancelRequestData = new AcceptCancelRequestData();
    if (acceptCancelRequest != null) {
      acceptCancelRequestData.setId(acceptCancelRequest.getId());
      acceptCancelRequestData
          .setAcceptedBy(UserToUserData.mapToUserData(acceptCancelRequest.getAcceptedBy()));
      acceptCancelRequestData.setCancelLeaveRequest(CancelLeaveRequestToCancelLeaveRequestData
          .mapToCancelLeaveRequestData(acceptCancelRequest.getCancelLeaveRequest()));
    }
    return acceptCancelRequestData;
  }

  public static List<AcceptCancelRequestData> mapToAcceptCancelRequestDataList(
      List<AcceptCancelRequest> acceptCancelRequestList) {
    List<AcceptCancelRequestData> acceptCancelRequestDataList =
        new ArrayList<AcceptCancelRequestData>();

    if (acceptCancelRequestList != null) {
      for (AcceptCancelRequest acceptCancelRequest : acceptCancelRequestList) {
        acceptCancelRequestDataList.add(mapToAcceptCancelRequestData(acceptCancelRequest));
      }
    }
    return acceptCancelRequestDataList;
  }

}
