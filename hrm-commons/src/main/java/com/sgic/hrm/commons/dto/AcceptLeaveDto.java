/**
 * 
 */
package com.sgic.hrm.commons.dto;

/**
 * @author Anushanth
 *
 */
public class AcceptLeaveDto {

  Integer leaveRequestId;
  String userName;

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

}
