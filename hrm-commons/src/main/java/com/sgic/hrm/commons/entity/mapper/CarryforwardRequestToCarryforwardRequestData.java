package com.sgic.hrm.commons.entity.mapper;

import java.util.ArrayList;
import java.util.List;
import com.sgic.hrm.commons.dto.CarryforwardRequestData;
import com.sgic.hrm.commons.entity.CarryforwardRequest;

public class CarryforwardRequestToCarryforwardRequestData {

	private CarryforwardRequestToCarryforwardRequestData() {}
	
  public static CarryforwardRequestData mapToCarryforwardRequestData(
      CarryforwardRequest carryforwardRequest) {
    CarryforwardRequestData carryforwardRequestData = new CarryforwardRequestData();
    if (carryforwardRequest != null) {
      carryforwardRequestData.setId(carryforwardRequest.getId());
      carryforwardRequestData.setCarryForwardDays(carryforwardRequest.getCarryForwardDays());
      carryforwardRequestData.setCreatedAt(carryforwardRequest.getCreatedAt());
      carryforwardRequestData.setUpdatedAt(carryforwardRequest.getUpdatedAt());
      carryforwardRequestData.setUser(UserToUserData.mapToUserData(carryforwardRequest.getUser()));
      carryforwardRequestData.setStatus(carryforwardRequest.getStatus());
      return carryforwardRequestData;
    }
    return null;
  }

  public static List<CarryforwardRequestData> mapToCarryforwardRequestDataList(
      List<CarryforwardRequest> carryforwardRequestList) {
    List<CarryforwardRequestData> carryforwardRequestDataList =
        new ArrayList<CarryforwardRequestData>();

    if (carryforwardRequestList != null) {
      for (CarryforwardRequest carryforwardRequest : carryforwardRequestList) {
        carryforwardRequestDataList.add(mapToCarryforwardRequestData(carryforwardRequest));
      }
    }
    return carryforwardRequestDataList;
  }

}
