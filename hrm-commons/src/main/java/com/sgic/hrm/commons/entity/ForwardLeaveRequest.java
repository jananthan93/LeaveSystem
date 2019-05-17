package com.sgic.hrm.commons.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "forward_leave_request",schema = "leavesystem")
public class ForwardLeaveRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2040431043930754254L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	@ManyToOne
	@JoinColumn(name = "forward_to")
	User forwardTo;

	@ManyToOne
	@JoinColumn(name = "leave_request_id")
	LeaveRequest leaveRequest;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getForwardTo() {
		return forwardTo;
	}

	public void setForwardTo(User forwardTo) {
		this.forwardTo = forwardTo;
	}

	public LeaveRequest getLeaveRequest() {
		return leaveRequest;
	}

	public void setLeaveRequest(LeaveRequest leaveRequest) {
		this.leaveRequest = leaveRequest;
	}

}
