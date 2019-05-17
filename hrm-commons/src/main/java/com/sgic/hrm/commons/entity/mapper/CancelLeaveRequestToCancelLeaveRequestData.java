package com.sgic.hrm.commons.entity.mapper;

import java.util.ArrayList;
import java.util.List;
import com.sgic.hrm.commons.dto.CancelLeaveRequestData;
import com.sgic.hrm.commons.entity.CancelLeaveRequest;

public class CancelLeaveRequestToCancelLeaveRequestData {

  public static CancelLeaveRequestData mapToCancelLeaveRequestData(
      CancelLeaveRequest cancelLeaveRequest) {
    CancelLeaveRequestData cancelLeaveRequestData = new CancelLeaveRequestData();

    if (cancelLeaveRequest != null) {
      cancelLeaveRequestData.setId(cancelLeaveRequest.getId());
      cancelLeaveRequestData.setReason(cancelLeaveRequest.getReason());
      cancelLeaveRequestData.setLeaveRequest(LeaveRequestToLeaveRequestData
          .mapToLeaveRequestData(cancelLeaveRequest.getLeaveRequest()));
      cancelLeaveRequestData.setStatus(cancelLeaveRequest.getStatus());
    }
    return cancelLeaveRequestData;
  }

  public static List<CancelLeaveRequestData> mapToCancelLeaveRequestData(
      List<CancelLeaveRequest> cancelLeaveRequestList) {
    List<CancelLeaveRequestData> cancelLeaveRequestDataList =
        new ArrayList<CancelLeaveRequestData>();
    if (cancelLeaveRequestList != null) {
      for (CancelLeaveRequest cancelLeaveRequest : cancelLeaveRequestList) {
        cancelLeaveRequestDataList.add(mapToCancelLeaveRequestData(cancelLeaveRequest));
      }
    }
    return cancelLeaveRequestDataList;
  }

}
