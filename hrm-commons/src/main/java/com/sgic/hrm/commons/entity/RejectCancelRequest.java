package com.sgic.hrm.commons.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reject_cancel_request",schema = "leavesystem")
public class RejectCancelRequest implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 4126349842710637665L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @OneToOne
  @JoinColumn(name = "cancel_leave_request_id")
  private CancelLeaveRequest cancelLeaveRequest;

  @ManyToOne
  @JoinColumn(name = "rejected_by")
  private User rejectedBy;

  @Column(name = "reason")
  private String reason;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public CancelLeaveRequest getCancelLeaveRequest() {
    return cancelLeaveRequest;
  }

  public void setCancelLeaveRequest(CancelLeaveRequest cancelLeaveRequest) {
    this.cancelLeaveRequest = cancelLeaveRequest;
  }

  public User getRejectedBy() {
    return rejectedBy;
  }

  public void setRejectedBy(User rejectedBy) {
    this.rejectedBy = rejectedBy;
  }

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

}
