package com.sgic.hrm.commons.dto;

public class AcceptCarryforwardRequestData {

	private Integer id;
	private CarryforwardRequestData carryforwardRequest;
	private UserData acceptedBy;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CarryforwardRequestData getCarryforwardRequest() {
		return carryforwardRequest;
	}

	public void setCarryforwardRequest(CarryforwardRequestData carryforwardRequest) {
		this.carryforwardRequest = carryforwardRequest;
	}

	public UserData getAcceptedBy() {
		return acceptedBy;
	}

	public void setAcceptedBy(UserData acceptedBy) {
		this.acceptedBy = acceptedBy;
	}

}
