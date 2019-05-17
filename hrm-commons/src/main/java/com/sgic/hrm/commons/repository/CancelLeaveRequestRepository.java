package com.sgic.hrm.commons.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sgic.hrm.commons.entity.CancelLeaveRequest;
import com.sgic.hrm.commons.entity.LeaveRequest;
import com.sgic.hrm.commons.enums.Status;

public interface CancelLeaveRequestRepository extends JpaRepository<CancelLeaveRequest, Integer> {

	List<CancelLeaveRequest> findByStatusOrderByIdDesc(Status status);
	
	@Query("SELECT clr FROM CancelLeaveRequest clr WHERE clr.leaveRequest.user.id = 0")
	List<CancelLeaveRequest> findByUser(Integer id);
	
	//jananthan
	CancelLeaveRequest findByLeaveRequest(LeaveRequest leaveRequest);
}
