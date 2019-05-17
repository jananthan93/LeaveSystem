package com.sgic.hrm.commons.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "leave_allocation", schema = "leavesystem")
public class LeaveAllocation implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -792211094556228192L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne
  @JoinColumn(name = "leave_type_id")
  private LeaveType leaveType;

  @Column(name = "allocated_days")
  private Double allocatedDays;

  @Column(name = "utilized_days")
  private Double utilizedDays;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public LeaveType getLeaveType() {
    return leaveType;
  }

  public void setLeaveType(LeaveType leaveType) {
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
