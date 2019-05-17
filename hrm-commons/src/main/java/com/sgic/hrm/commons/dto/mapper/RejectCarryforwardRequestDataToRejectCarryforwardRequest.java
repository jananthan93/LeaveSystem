package com.sgic.hrm.commons.dto.mapper;

import java.util.ArrayList;
import java.util.List;
import com.sgic.hrm.commons.dto.RejectCarryforwardRequestData;
import com.sgic.hrm.commons.entity.RejectCarryforwardRequest;

public class RejectCarryforwardRequestDataToRejectCarryforwardRequest {

  public static RejectCarryforwardRequest mapToRejectCarryforwardRequest(
      RejectCarryforwardRequestData rejectCarryforwardRequestData) {
    RejectCarryforwardRequest rejectCarryforwardRequest = new RejectCarryforwardRequest();

    if (rejectCarryforwardRequestData != null) {
      rejectCarryforwardRequest.setId(rejectCarryforwardRequestData.getId());
      rejectCarryforwardRequest.setReason(rejectCarryforwardRequestData.getReason());
      rejectCarryforwardRequest.setCarryforwardRequest(CarryforwardRequestDataToCarryforwardRequest
          .mapToCarryforwardRequest(rejectCarryforwardRequestData.getCarryforwardRequest()));
      rejectCarryforwardRequest
          .setRejectedBy(UserDataToUser.mapToUser(rejectCarryforwardRequestData.getRejectedBy()));
    }
    return rejectCarryforwardRequest;
  }

  public static List<RejectCarryforwardRequest> mapToRejectCarryforwardRequestList(
      List<RejectCarryforwardRequestData> rejectCarryforwardRequestDataList) {
    List<RejectCarryforwardRequest> rejectCarryforwardRequestList =
        new ArrayList<RejectCarryforwardRequest>();
    if (rejectCarryforwardRequestDataList != null) {
      for (RejectCarryforwardRequestData rejectCarryforwardRequestData : rejectCarryforwardRequestDataList) {
        rejectCarryforwardRequestList
            .add(mapToRejectCarryforwardRequest(rejectCarryforwardRequestData));
      }
    }
    return rejectCarryforwardRequestList;
  }
}
