package com.sgic.hrm.commons.entity.mapper;

import java.util.ArrayList;
import java.util.List;
import com.sgic.hrm.commons.dto.RejectCancelRequestData;
import com.sgic.hrm.commons.entity.RejectCancelRequest;

public class RejectCancelRequestToRejectCancelRequestData {

  public static RejectCancelRequestData mapToRejectCancelRequestData(
      RejectCancelRequest rejectCancelRequest) {
    RejectCancelRequestData rejectCancelRequestData = new RejectCancelRequestData();
    if (rejectCancelRequest != null) {
      rejectCancelRequestData.setId(rejectCancelRequest.getId());
      rejectCancelRequestData.setReason(rejectCancelRequest.getReason());
      rejectCancelRequestData.setCancelLeaveRequest(CancelLeaveRequestToCancelLeaveRequestData
          .mapToCancelLeaveRequestData(rejectCancelRequest.getCancelLeaveRequest()));
      rejectCancelRequestData
          .setRejectedBy(UserToUserData.mapToUserData(rejectCancelRequest.getRejectedBy()));
    }
    return rejectCancelRequestData;
  }

  public static List<RejectCancelRequestData> mapToRejectCancelRequestDataList(
      List<RejectCancelRequest> rejectCancelRequestList) {
    List<RejectCancelRequestData> rejectCancelRequestDataList =
        new ArrayList<RejectCancelRequestData>();
    if (rejectCancelRequestList != null) {
      for (RejectCancelRequest rejectCancelRequest : rejectCancelRequestList) {
        rejectCancelRequestDataList.add(mapToRejectCancelRequestData(rejectCancelRequest));
      }
    }
    return rejectCancelRequestDataList;
  }

}
