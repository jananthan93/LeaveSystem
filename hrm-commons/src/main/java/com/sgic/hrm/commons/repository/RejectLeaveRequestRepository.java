package com.sgic.hrm.commons.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.hrm.commons.entity.LeaveRequest;
import com.sgic.hrm.commons.entity.RejectLeaveRequest;

public interface RejectLeaveRequestRepository extends JpaRepository<RejectLeaveRequest, Integer>{

	List<RejectLeaveRequest> findAllByOrderByIdDesc();
}
