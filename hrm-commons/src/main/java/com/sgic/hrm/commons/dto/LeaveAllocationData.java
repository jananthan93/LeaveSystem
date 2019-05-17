package com.sgic.hrm.commons.dto;

public class LeaveAllocationData {

  private Integer id;
  private UserData user;
  private LeaveTypeData leaveType;
  private Double allocatedDays;
  private Double utilizedDays;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public UserData getUser() {
    return user;
  }

  public void setUser(UserData user) {
    this.user = user;
  }

  public LeaveTypeData getLeaveType() {
    return leaveType;
  }

  public void setLeaveType(LeaveTypeData leaveType) {
    this.leaveType = leaveType;
  }

  public Double getAllocatedDays() {
    return allocatedDays;
  }

  public void setAllocatedDays(Double allocatedDays) {
    this.allocatedDays = allocatedDays;
  }

  public Double getUtilizedDays() {
    return utilizedDays;
  }

  public void setUtilizedDays(Double utilizedDays) {
    this.utilizedDays = utilizedDays;
  }

}
