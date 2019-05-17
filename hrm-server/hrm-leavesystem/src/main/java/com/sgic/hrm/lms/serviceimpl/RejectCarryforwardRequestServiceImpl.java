package com.sgic.hrm.lms.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.RejectCarryforwardRequest;
import com.sgic.hrm.commons.repository.CarryforwardRequestRepository;
import com.sgic.hrm.commons.repository.RejectCarryforwardRequestRepository;
import com.sgic.hrm.lms.service.LoginService;
import com.sgic.hrm.lms.service.RejectCarryforwardRequestService;

@Service
public class RejectCarryforwardRequestServiceImpl implements RejectCarryforwardRequestService{
	@Autowired
	RejectCarryforwardRequestRepository rejectCarryforwardRequestRepository;
	@Autowired
	CarryforwardRequestRepository carryforwardRequestRepository;
	@Autowired 
	LoginService loginService;

	@Override
	public boolean addRejectCarryforwardRequest(RejectCarryforwardRequest rejectCarryforwardRequest) {
		rejectCarryforwardRequestRepository.save(rejectCarryforwardRequest);
		return true;
	}

	@Override
	public boolean editRejectCarryforwardRequest(Integer id, RejectCarryforwardRequest rejectCarryforwardRequest) {
		if (rejectCarryforwardRequestRepository.getOne(id) != null) {
			rejectCarryforwardRequest.setId(id);
			rejectCarryforwardRequestRepository.save(rejectCarryforwardRequest);
			return true;
		}
		return false;
	}

	@Override
	public List<RejectCarryforwardRequest> getAllRejectCarryforwardRequest() {
		return rejectCarryforwardRequestRepository.findAll();
	}

	@Override
	public RejectCarryforwardRequest getRejectCarryforwardRequest(Integer id) {
		return rejectCarryforwardRequestRepository.findById(id).orElse(null);
	}

	@Override
	public boolean deleteRejectCarryforwardRequest(Integer id) {
		if (rejectCarryforwardRequestRepository.getOne(id) != null) {
			rejectCarryforwardRequestRepository.deleteById(id);
			return true;
		}
		return false;
	}

		@Override
		public RejectCarryforwardRequest getRejectCarryforwardRequestByUser(String userName) {
			System.out.println(loginService.getUser(userName).getFullName());
			return rejectCarryforwardRequestRepository.findByCarryforwardRequest(
					carryforwardRequestRepository.findByUser(loginService.getUser(userName)));
		}
		
	}

	
	


