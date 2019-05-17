package com.sgic.hrm.commons.dto.mapper;

import java.util.ArrayList;
import java.util.List;
import com.sgic.hrm.commons.dto.RejectLeaveRequestData;
import com.sgic.hrm.commons.entity.RejectLeaveRequest;

public class RejectLeaveRequestDataToRejectLeaveRequest {

  public static RejectLeaveRequest mapToRejectLeaveRequest(
      RejectLeaveRequestData rejectLeaveRequestdata) {
    RejectLeaveRequest rejectLeaveRequest = new RejectLeaveRequest();

    if (rejectLeaveRequestdata != null) {
      rejectLeaveRequest.setId(rejectLeaveRequestdata.getId());
      rejectLeaveRequest.setReason(rejectLeaveRequestdata.getReason());
      rejectLeaveRequest.setLeaveRequest(
          LeaveRequestDataToLeaveRequest.mapToLeaveRequest(rejectLeaveRequestdata.getLeaveRequest()));

    }
    return rejectLeaveRequest;
  }

  public static List<RejectLeaveRequest> mapToRejectLeaveRequestData(
      List<RejectLeaveRequestData> rejectLeaveRequestDataList) {
    List<RejectLeaveRequest> rejectLeaveRequestList = new ArrayList<RejectLeaveRequest>();

    if (rejectLeaveRequestDataList != null) {
      for (RejectLeaveRequestData rejectLeaveRequestData : rejectLeaveRequestDataList) {
        rejectLeaveRequestList.add(mapToRejectLeaveRequest(rejectLeaveRequestData));
      }
    }
    return rejectLeaveRequestList;
  }
}
