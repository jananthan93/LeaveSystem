package com.sgic.hrm.commons.entity.mapper;

import java.util.ArrayList;
import java.util.List;

import com.sgic.hrm.commons.dto.AcceptCarryforwardRequestData;
import com.sgic.hrm.commons.entity.AcceptCarryforwardRequest;

public class AcceptCarryforwardRequestToAcceptCarryforwardData {

	public static AcceptCarryforwardRequestData mapToAcceptCarryforwardRequestData(
			AcceptCarryforwardRequest acceptCarryforwardRequest) {
		AcceptCarryforwardRequestData acceptCarryforwardRequestData = new AcceptCarryforwardRequestData();

		if (acceptCarryforwardRequest != null) {
			acceptCarryforwardRequestData.setId(acceptCarryforwardRequest.getId());
			acceptCarryforwardRequestData.setCarryforwardRequest(CarryforwardRequestToCarryforwardRequestData
					.mapToCarryforwardRequestData(acceptCarryforwardRequest.getCarryforwardRequest()));
			acceptCarryforwardRequestData
					.setAcceptedBy(UserToUserData.mapToUserData(acceptCarryforwardRequest.getAcceptedBy()));
		}
		return acceptCarryforwardRequestData;
	}

	public static List<AcceptCarryforwardRequestData> mapToAcceptCarryforwardRequestDataList(
			List<AcceptCarryforwardRequest> acceptCarryforwardRequestList) {
		List<AcceptCarryforwardRequestData> acceptCarryforwardRequestDataList = new ArrayList<AcceptCarryforwardRequestData>();
		if (acceptCarryforwardRequestList != null) {
			for (AcceptCarryforwardRequest acceptCarryforwardRequest : acceptCarryforwardRequestList) {
				acceptCarryforwardRequestDataList.add(mapToAcceptCarryforwardRequestData(acceptCarryforwardRequest));
			}
		}
		return acceptCarryforwardRequestDataList;
	}

}
