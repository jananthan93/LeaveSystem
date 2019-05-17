package com.sgic.hrm.lms.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.RejectLeaveRequest;
import com.sgic.hrm.commons.repository.RejectLeaveRequestRepository;
import com.sgic.hrm.lms.service.RejectLeaveRequestService;

@Service
public class RejectLeaveRequestServiceImpl implements RejectLeaveRequestService{

	@Autowired
	RejectLeaveRequestRepository rejectLeaveRequestRepository;

	@Override
	public boolean addRejectLeaveRequest(RejectLeaveRequest rejectLeaveRequest) {
		rejectLeaveRequestRepository.save(rejectLeaveRequest);
		return true;
	}

	@Override
	public boolean editRejectLeaveRequest(Integer id, RejectLeaveRequest rejectLeaveRequest) {
		if (rejectLeaveRequestRepository.getOne(id) != null) {
			rejectLeaveRequest.setId(id);
			rejectLeaveRequestRepository.save(rejectLeaveRequest);
			return true;
		}
		return false;
	}

	@Override
	public List<RejectLeaveRequest> getAllRejectLeaveRequest() {
		return rejectLeaveRequestRepository.findAllByOrderByIdDesc();
	}

	@Override
	public RejectLeaveRequest getRejectLeaveRequest(Integer id) {
		return rejectLeaveRequestRepository.findById(id).orElse(null);
	}

	@Override
	public boolean deleteRejectLeaveRequest(Integer id) {
		if (rejectLeaveRequestRepository.getOne(id) != null) {
			rejectLeaveRequestRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
