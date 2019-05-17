package com.sgic.hrm.commons.entity.mapper;

import java.util.ArrayList;
import java.util.List;

import com.sgic.hrm.commons.dto.RejectLeaveRequestData;
import com.sgic.hrm.commons.entity.RejectLeaveRequest;

public class RejectLeaveRequestToRejectLeaveRequestData {

	public static RejectLeaveRequestData mapToRejectLeaveRequestData(RejectLeaveRequest rejectLeaveRequest) {
		RejectLeaveRequestData rejectLeaveRequestData = new RejectLeaveRequestData();
		if (rejectLeaveRequest != null) {
			rejectLeaveRequestData.setId(rejectLeaveRequest.getId());
			rejectLeaveRequestData.setReason(rejectLeaveRequest.getReason());
			rejectLeaveRequestData.setRejectedBy(UserToUserData.mapToUserData(rejectLeaveRequest.getRejectedBy()));
			rejectLeaveRequestData.setLeaveRequest(
					LeaveRequestToLeaveRequestData.mapToLeaveRequestData(rejectLeaveRequest.getLeaveRequest()));
		}
		return rejectLeaveRequestData;
	}

	public static List<RejectLeaveRequestData> mapToRejectLeaveRequestDataList(
			List<RejectLeaveRequest> rejectLeaveRequestList) {
		List<RejectLeaveRequestData> rejectLeaveRequestDataList = new ArrayList<RejectLeaveRequestData>();
		if(rejectLeaveRequestList != null) {
			for(RejectLeaveRequest rejectLeaveRequest : rejectLeaveRequestList) {
				rejectLeaveRequestDataList.add(mapToRejectLeaveRequestData(rejectLeaveRequest));
			}
		}
		return rejectLeaveRequestDataList;

	}

}
