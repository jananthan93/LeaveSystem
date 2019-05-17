package com.sgic.hrm.lms.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.AcceptLeaveRequest;
import com.sgic.hrm.commons.repository.AcceptLeaveRequestRepository;
import com.sgic.hrm.lms.service.AcceptLeaveRequestService;

@Service
public class AcceptLeaveRequestServiceImpl implements AcceptLeaveRequestService{
	@Autowired
	AcceptLeaveRequestRepository acceptLeaveRequestRepository;

	@Override
	public boolean addAcceptLeaveRequest(AcceptLeaveRequest acceptLeaveRequest) {
		acceptLeaveRequestRepository.save(acceptLeaveRequest);
		return true;
	}

	@Override
	public boolean editAcceptLeaveRequest(Integer id, AcceptLeaveRequest acceptLeaveRequest) {
		if (acceptLeaveRequestRepository.getOne(id) != null) {
			acceptLeaveRequest.setId(id);
			acceptLeaveRequestRepository.save(acceptLeaveRequest);
			return true;
		}
		return false;
	}

	@Override
	public List<AcceptLeaveRequest> getAllAcceptLeaveRequests() {
		return acceptLeaveRequestRepository.findAllByOrderByIdDesc();
	}

	@Override
	public AcceptLeaveRequest getAcceptLeaveRequest(Integer id) {
		return acceptLeaveRequestRepository.findById(id).orElse(null);
	}

	@Override
	public boolean deleteAcceptLeaveRequest(Integer id) {
		if (acceptLeaveRequestRepository.getOne(id) != null) {
			acceptLeaveRequestRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
	

}
