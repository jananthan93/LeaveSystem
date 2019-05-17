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
@Table(name = "accept_carryforward_request",schema = "leavesystem")
public class AcceptCarryforwardRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8390568963612482507L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToOne
	@JoinColumn(name = "carryforward_request_id")
	private CarryforwardRequest carryforwardRequest;

	@ManyToOne
	@JoinColumn(name = "accepted_by")
	private User acceptedBy;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CarryforwardRequest getCarryforwardRequest() {
		return carryforwardRequest;
	}

	public void setCarryforwardRequest(CarryforwardRequest carryforwardRequest) {
		this.carryforwardRequest = carryforwardRequest;
	}

	public User getAcceptedBy() {
		return acceptedBy;
	}

	public void setAcceptedBy(User acceptedBy) {
		this.acceptedBy = acceptedBy;
	}

}
