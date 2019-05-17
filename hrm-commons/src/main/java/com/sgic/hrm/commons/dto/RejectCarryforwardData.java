package com.sgic.hrm.commons.dto;

public class RejectCarryforwardData {

	private CarryforwardRequestData carryforwardRequestData;
	private String reason;

	public CarryforwardRequestData getCarryforwardRequestData() {
		return carryforwardRequestData;
	}

	public void setCarryforwardRequestData(CarryforwardRequestData carryforwardRequestData) {
		this.carryforwardRequestData = carryforwardRequestData;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

}
