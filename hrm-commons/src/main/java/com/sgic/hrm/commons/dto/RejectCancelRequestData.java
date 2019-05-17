package com.sgic.hrm.commons.dto;

public class RejectCancelRequestData {

  private Integer id;
  private CancelLeaveRequestData cancelLeaveRequest;
  private UserData rejectedBy;
  private String reason;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public CancelLeaveRequestData getCancelLeaveRequest() {
    return cancelLeaveRequest;
  }

  public void setCancelLeaveRequest(CancelLeaveRequestData cancelLeaveRequest) {
    this.cancelLeaveRequest = cancelLeaveRequest;
  }

  public UserData getRejectedBy() {
    return rejectedBy;
  }

  public void setRejectedBy(UserData rejectedBy) {
    this.rejectedBy = rejectedBy;
  }

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

}
