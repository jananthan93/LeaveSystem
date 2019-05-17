package com.sgic.hrm.commons.dto;

public class ForwardLeaveRequestData {

	Integer id;
	UserData forwardTo;
	LeaveRequestData leaveRequest;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserData getForwardTo() {
		return forwardTo;
	}

	public void setForwardTo(UserData forwardTo) {
		this.forwardTo = forwardTo;
	}

	public LeaveRequestData getLeaveRequest() {
		return leaveRequest;
	}

	public void setLeaveRequest(LeaveRequestData leaveRequest) {
		this.leaveRequest = leaveRequest;
	}

}
