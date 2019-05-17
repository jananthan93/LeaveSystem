package com.sgic.hrm.commons.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "accept_cancel_request",schema = "leavesystem")
public class AcceptCancelRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5095838859692805752L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToOne
	@JoinColumn(name = "cancel_leave_request_id")
	private CancelLeaveRequest cancelLeaveRequest;

	@ManyToOne
	@JoinColumn(name = "accepted_by")
	private User acceptedBy;

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

	public User getAcceptedBy() {
		return acceptedBy;
	}

	public void setAcceptedBy(User acceptedBy) {
		this.acceptedBy = acceptedBy;
	}
}
