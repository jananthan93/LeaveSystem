package com.sgic.hrm.commons.dto.mapper;

import java.util.ArrayList;
import java.util.List;
import com.sgic.hrm.commons.dto.CarryforwardRequestData;
import com.sgic.hrm.commons.entity.CarryforwardRequest;

public class CarryforwardRequestDataToCarryforwardRequest {

  public static CarryforwardRequest mapToCarryforwardRequest(
      CarryforwardRequestData carryforwardRequestData) {
    CarryforwardRequest carryforwardRequest = new CarryforwardRequest();
    if (carryforwardRequestData != null) {
      carryforwardRequest.setId(carryforwardRequestData.getId());
      carryforwardRequest.setCarryForwardDays(carryforwardRequestData.getCarryForwardDays());
      carryforwardRequest.setUser(UserDataToUser.mapToUser(carryforwardRequestData.getUser()));
      carryforwardRequest.setStatus(carryforwardRequestData.getStatus());
    }
    return carryforwardRequest;
  }

  public static List<CarryforwardRequest> mapToCarryforwardRequestList(
      List<CarryforwardRequestData> carryforwardRequestDataList) {
    List<CarryforwardRequest> carryforwardRequestList = new ArrayList<CarryforwardRequest>();

    if (carryforwardRequestDataList != null) {
      for (CarryforwardRequestData carryforwardRequestData : carryforwardRequestDataList) {
        carryforwardRequestList.add(mapToCarryforwardRequest(carryforwardRequestData));
      }
    }
    return carryforwardRequestList;
  }

}
