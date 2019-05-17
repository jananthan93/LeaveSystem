package com.sgic.hrm.commons.dto;

import java.time.ZonedDateTime;

public class LeaveTypeData {

  private Integer id;
  private String leaveTypeValue;
  private Double defaultAllocation;
  private ZonedDateTime createdAt;
  private ZonedDateTime updatedAt;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getLeaveTypeValue() {
    return leaveTypeValue;
  }

  public void setLeaveTypeValue(String leaveTypeValue) {
    this.leaveTypeValue = leaveTypeValue;
  }

  public Double getDefaultAllocation() {
    return defaultAllocation;
  }

  public void setDefaultAllocation(Double defaultAllocation) {
    this.defaultAllocation = defaultAllocation;
  }

  public ZonedDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(ZonedDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public ZonedDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(ZonedDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

}
