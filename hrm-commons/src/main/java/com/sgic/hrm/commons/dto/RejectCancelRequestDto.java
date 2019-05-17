/**
 * 
 */
package com.sgic.hrm.commons.dto;

/**
 * @author Anushanth
 *
 */
public class RejectCancelRequestDto {

  Integer cancelRequestId;
  String userName;
  String rejectReason;

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

  public String getRejectReason() {
    return rejectReason;
  }

  public void setRejectReason(String rejectReason) {
    this.rejectReason = rejectReason;
  }


}
