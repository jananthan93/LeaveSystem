package com.sgic.hrm.commons.dto;

public class RejectLeaveDto {

  Integer leaveRequestId;
  String userName;
  String rejectReason;

  public Integer getLeaveRequestId() {
    return leaveRequestId;
  }

  public void setLeaveRequestId(Integer leaveRequestId) {
    this.leaveRequestId = leaveRequestId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getRejectReason() {
    return rejectReason;
  }

  public void setRejectReason(String rejectReason) {
    this.rejectReason = rejectReason;
  }

}
