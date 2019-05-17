package com.sgic.hrm.commons.dto;

public class AcceptCancelRequestDto {

  Integer cancelRequestId;
  String userName;

  public Integer getCancelRequestId() {
    return cancelRequestId;
  }

  public void setCancelRequestId(Integer cancelRequestId) {
    this.cancelRequestId = cancelRequestId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

}
