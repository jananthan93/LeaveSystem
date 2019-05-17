package com.sgic.hrm.commons.dto.mapper;

import java.util.ArrayList;
import java.util.List;
import com.sgic.hrm.commons.dto.RejectCancelRequestData;
import com.sgic.hrm.commons.entity.RejectCancelRequest;

public class RejectCancelRequestDataToRejectCancelRequest {

  public static RejectCancelRequest mapToRejectCancelRequest(
      RejectCancelRequestData rejectCancelRequestData) {

    RejectCancelRequest rejectCancelRequest = new RejectCancelRequest();

    if (rejectCancelRequestData != null) {
      rejectCancelRequest.setId(rejectCancelRequestData.getId());
      rejectCancelRequest.setCancelLeaveRequest(CancelLeaveRequestDataToCancelLeaveRequest
          .mapToCancelLeaveRequest(rejectCancelRequestData.getCancelLeaveRequest()));
      rejectCancelRequest
          .setRejectedBy(UserDataToUser.mapToUser(rejectCancelRequestData.getRejectedBy()));
      rejectCancelRequest.setReason(rejectCancelRequestData.getReason());
    }
    return rejectCancelRequest;
  }

  public static List<RejectCancelRequest> mapToRejectCancelRequestData(
      List<RejectCancelRequestData> rejectCancelRequestDataList) {
    List<RejectCancelRequest> rejectCancelRequestList = new ArrayList<RejectCancelRequest>();

    if (rejectCancelRequestDataList != null) {
      for (RejectCancelRequestData rejectCancelRequestData : rejectCancelRequestDataList) {
        rejectCancelRequestList.add(mapToRejectCancelRequest(rejectCancelRequestData));
      }
    }
    return rejectCancelRequestList;
  }
}
