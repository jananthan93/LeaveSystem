package com.sgic.hrm.commons.entity.mapper;

import java.util.ArrayList;
import java.util.List;
import com.sgic.hrm.commons.dto.RejectCarryforwardRequestData;
import com.sgic.hrm.commons.entity.RejectCarryforwardRequest;

public class RejectCarryforwardRequestToRejectCarryforwardRequestData {

  public static RejectCarryforwardRequestData mapToRejectCarryforwardRequestData(
      RejectCarryforwardRequest rejectCarryforwardRequest) {
    RejectCarryforwardRequestData rejectCarryforwardRequestData =
        new RejectCarryforwardRequestData();

    if (rejectCarryforwardRequest != null) {
      rejectCarryforwardRequestData.setId(rejectCarryforwardRequest.getId());
      rejectCarryforwardRequestData.setReason(rejectCarryforwardRequest.getReason());
      rejectCarryforwardRequestData
          .setCarryforwardRequest(CarryforwardRequestToCarryforwardRequestData
              .mapToCarryforwardRequestData(rejectCarryforwardRequest.getCarryforwardRequest()));
      rejectCarryforwardRequestData
          .setRejectedBy(UserToUserData.mapToUserData(rejectCarryforwardRequest.getRejectedBy()));
    }
    return rejectCarryforwardRequestData;
  }


  public static List<RejectCarryforwardRequestData> mapToRejectCarryforwardRequestDataList(
      List<RejectCarryforwardRequest> rejectCarryforwardRequestList) {
    List<RejectCarryforwardRequestData> rejectCarryforwardRequestDataList =
        new ArrayList<RejectCarryforwardRequestData>();
    if (rejectCarryforwardRequestList != null) {
      for (RejectCarryforwardRequest rejectCarryforwardRequest : rejectCarryforwardRequestList) {
        rejectCarryforwardRequestDataList
            .add(mapToRejectCarryforwardRequestData(rejectCarryforwardRequest));
      }
    }
    return rejectCarryforwardRequestDataList;
  }

}
