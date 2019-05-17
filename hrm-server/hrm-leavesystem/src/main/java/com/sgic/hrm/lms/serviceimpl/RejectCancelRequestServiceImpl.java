package com.sgic.hrm.lms.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.RejectCancelRequest;
import com.sgic.hrm.commons.repository.CancelLeaveRequestRepository;
import com.sgic.hrm.commons.repository.LeaveRequestRepository;
import com.sgic.hrm.commons.repository.RejectCancelRequestRepository;
import com.sgic.hrm.lms.service.RejectCancelRequestService;

@Service
public class RejectCancelRequestServiceImpl implements RejectCancelRequestService {
	@Autowired
	RejectCancelRequestRepository rejectCancelRequestRepository;
	//jananthan
	@Autowired
	CancelLeaveRequestRepository cancelLeaveRequestRepository;
	@Autowired
	LeaveRequestRepository leaveRequestRepository;

	@Override
	public boolean addRejectCancelRequest(RejectCancelRequest rejectCancelRequest) {
		rejectCancelRequestRepository.save(rejectCancelRequest);
		return true;
	}

	@Override
	public boolean editRejectCancelRequest(Integer id, RejectCancelRequest rejectCancelRequest) {
		if (rejectCancelRequestRepository.getOne(id) != null) {
			rejectCancelRequest.setId(id);
			rejectCancelRequestRepository.save(rejectCancelRequest);
			return true;
		}
		return false;
	}

	@Override
	public List<RejectCancelRequest> getAllRejectCancelRequests() {
		return rejectCancelRequestRepository.findAll();

	}

	@Override
	public RejectCancelRequest getRejectCancelRequest(Integer id) {
		return rejectCancelRequestRepository.findById(id).orElse(null);
	}

	@Override
	public boolean deleteRejectCancelRequest(Integer id) {
		if (rejectCancelRequestRepository.getOne(id) != null) {
			rejectCancelRequestRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
	//Code done by Jananthan
	@Override
	public RejectCancelRequest getRejectCancelRequestByLeaveRequest(Integer id) {
		return rejectCancelRequestRepository.findByCancelLeaveRequest(
				cancelLeaveRequestRepository.findByLeaveRequest(leaveRequestRepository.findLeaveRequestById(id)));
	}

}
