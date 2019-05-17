package com.sgic.hrm.commons.dto;

public class AcceptCancelRequestData {

	private Integer id;
	private CancelLeaveRequestData cancelLeaveRequest;
	private UserData acceptedBy;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CancelLeaveRequestData getCancelLeaveRequest() {
		return cancelLeaveRequest;
	}

	public void setCancelLeaveRequest(CancelLeaveRequestData cancelLeaveRequest) {
		this.cancelLeaveRequest = cancelLeaveRequest;
	}

	public UserData getAcceptedBy() {
		return acceptedBy;
	}

	public void setAcceptedBy(UserData acceptedBy) {
		this.acceptedBy = acceptedBy;
	}

}
