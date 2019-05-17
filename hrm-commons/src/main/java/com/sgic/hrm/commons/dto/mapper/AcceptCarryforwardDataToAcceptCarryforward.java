package com.sgic.hrm.commons.dto.mapper;

import java.util.ArrayList;
import java.util.List;
import com.sgic.hrm.commons.dto.AcceptCarryforwardRequestData;
import com.sgic.hrm.commons.entity.AcceptCarryforwardRequest;

public class AcceptCarryforwardDataToAcceptCarryforward {

  public static AcceptCarryforwardRequest mapToAcceptCarryforwardRequest(
      AcceptCarryforwardRequestData acceptCarryforwardRequestData) {
    
  AcceptCarryforwardRequest acceptCarryforwardRequest = new AcceptCarryforwardRequest();

  if (acceptCarryforwardRequestData != null) {
      acceptCarryforwardRequest.setId(acceptCarryforwardRequestData.getId());
      acceptCarryforwardRequest.setCarryforwardRequest(CarryforwardRequestDataToCarryforwardRequest
              .mapToCarryforwardRequest(acceptCarryforwardRequestData.getCarryforwardRequest()));
      acceptCarryforwardRequest
              .setAcceptedBy(UserDataToUser.mapToUser(acceptCarryforwardRequestData.getAcceptedBy()));
  }
  return acceptCarryforwardRequest;
}

public static List<AcceptCarryforwardRequest> mapToAcceptCarryforwardRequestList(
      List<AcceptCarryforwardRequestData> acceptCarryforwardRequestDataList) {
  List<AcceptCarryforwardRequest> acceptCarryforwardRequestList = new ArrayList<AcceptCarryforwardRequest>();
  if (acceptCarryforwardRequestDataList != null) {
      for (AcceptCarryforwardRequestData acceptCarryforwardRequestData : acceptCarryforwardRequestDataList) {
          acceptCarryforwardRequestList.add(mapToAcceptCarryforwardRequest(acceptCarryforwardRequestData));
      }
  }
  return acceptCarryforwardRequestList;
}
}
