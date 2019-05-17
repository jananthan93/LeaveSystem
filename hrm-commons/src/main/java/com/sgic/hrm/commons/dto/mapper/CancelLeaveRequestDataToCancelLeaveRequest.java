package com.sgic.hrm.commons.dto.mapper;

import java.util.ArrayList;
import java.util.List;
import com.sgic.hrm.commons.dto.CancelLeaveRequestData;
import com.sgic.hrm.commons.entity.CancelLeaveRequest;


public class CancelLeaveRequestDataToCancelLeaveRequest {

  public static CancelLeaveRequest mapToCancelLeaveRequest(
      CancelLeaveRequestData cancelLeaveRequestData) {
    CancelLeaveRequest cancelLeaveRequest = new CancelLeaveRequest();

    if (cancelLeaveRequestData != null) {
      cancelLeaveRequest.setId(cancelLeaveRequestData.getId());
      cancelLeaveRequest.setReason(cancelLeaveRequestData.getReason());
      cancelLeaveRequest.setLeaveRequest(LeaveRequestDataToLeaveRequest
          .mapToLeaveRequest(cancelLeaveRequestData.getLeaveRequest()));
      cancelLeaveRequest.setStatus(cancelLeaveRequestData.getStatus());
    }
    return cancelLeaveRequest;
  }

  public static List<CancelLeaveRequest> mapToCancelLeaveRequestList(
      List<CancelLeaveRequestData> cancelLeaveRequestDataList) {
    List<CancelLeaveRequest> cancelLeaveRequestList = new ArrayList<CancelLeaveRequest>();

    if (cancelLeaveRequestDataList != null) {
      for (CancelLeaveRequestData cancelLeaveRequestData : cancelLeaveRequestDataList) {
        cancelLeaveRequestList.add(mapToCancelLeaveRequest(cancelLeaveRequestData));
      }
    }
    return cancelLeaveRequestList;
  }
}
