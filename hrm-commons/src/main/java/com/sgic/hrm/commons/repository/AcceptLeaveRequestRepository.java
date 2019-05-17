package com.sgic.hrm.commons.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.hrm.commons.entity.AcceptLeaveRequest;

public interface AcceptLeaveRequestRepository extends JpaRepository<AcceptLeaveRequest, Integer>{
	List<AcceptLeaveRequest> findAllByOrderByIdDesc();
	
}
