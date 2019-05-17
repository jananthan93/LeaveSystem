package com.sgic.hrm.commons.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.hrm.commons.entity.CarryforwardRequest;
import com.sgic.hrm.commons.entity.RejectCarryforwardRequest;

public interface RejectCarryforwardRequestRepository extends JpaRepository<RejectCarryforwardRequest, Integer>{
	RejectCarryforwardRequest findByCarryforwardRequest(CarryforwardRequest carryforwardRequest);
}
