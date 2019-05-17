package com.sgic.hrm.commons.entity;

import java.io.File;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import com.sgic.hrm.commons.enums.Status;

@Entity
@Table(name = "leave_request", schema = "leavesystem")
public class LeaveRequest implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -226677173807650191L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne
  @JoinColumn(name = "leave_Allocation_id")
  private LeaveAllocation leaveAllocation;

  @Column(name = "start_date")
  private Date startDate;

  @Column(name = "end_date")
  private Date endDate;

  @Column(name = "no_of_days")
  private Double noOfDays;

  @Column(name = "reason")
  private String reason;

  @Column(name = "attachment")
  private File attachment;

  @Column(name = "status")
  private Status status;

  @CreationTimestamp
  @Column(name = "created_at", nullable = false, updatable = false)
  private ZonedDateTime createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at", nullable = false)
  private ZonedDateTime updatedAt;

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

  public LeaveAllocation getLeaveAllocation() {
    return leaveAllocation;
  }

  public void setLeaveAllocation(LeaveAllocation leaveAllocation) {
    this.leaveAllocation = leaveAllocation;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public File getAttachment() {
    return attachment;
  }

  public void setAttachment(File attachment) {
    this.attachment = attachment;
  }

  public ZonedDateTime getCreatedAt() {
    return createdAt;
  }

  public ZonedDateTime getUpdatedAt() {
    return updatedAt;
  }

  public Double getNoOfDays() {
    return noOfDays;
  }

  public void setNoOfDays(Double noOfDays) {
    this.noOfDays = noOfDays;
  }

}
