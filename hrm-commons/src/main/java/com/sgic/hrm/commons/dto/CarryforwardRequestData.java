package com.sgic.hrm.commons.dto;

import java.time.ZonedDateTime;
import com.sgic.hrm.commons.enums.Status;

public class CarryforwardRequestData {

  private Integer id;
  private Integer carryForwardDays;
  private UserData user;
  private Status status;
  private ZonedDateTime createdAt;
  private ZonedDateTime updatedAt;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getCarryForwardDays() {
    return carryForwardDays;
  }

  public void setCarryForwardDays(Integer carryForwardDays) {
    this.carryForwardDays = carryForwardDays;
  }

  public UserData getUser() {
    return user;
  }

  public void setUser(UserData user) {
    this.user = user;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
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
