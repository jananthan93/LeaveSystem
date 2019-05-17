package com.sgic.hrm.commons.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.hrm.commons.entity.CancelLeaveRequest;
import com.sgic.hrm.commons.entity.RejectCancelRequest;

public interface RejectCancelRequestRepository extends JpaRepository<RejectCancelRequest, Integer> {
//	Jananthan
	RejectCancelRequest findByCancelLeaveRequest(CancelLeaveRequest cancelLeaveRequest);
}
