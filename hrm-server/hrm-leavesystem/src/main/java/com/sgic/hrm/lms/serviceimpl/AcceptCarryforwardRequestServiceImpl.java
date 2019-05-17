package com.sgic.hrm.lms.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.AcceptCarryforwardRequest;
import com.sgic.hrm.commons.repository.AcceptCarryForwardRequestRepository;
import com.sgic.hrm.lms.service.AcceptCarryforwardRequestService;

@Service
public class AcceptCarryforwardRequestServiceImpl implements AcceptCarryforwardRequestService {
	@Autowired
	AcceptCarryForwardRequestRepository acceptCarryforwardRequestRepository;

	@Override
	public boolean addAcceptCarryforwardRequest(AcceptCarryforwardRequest acceptCarryforwardRequest) {
		acceptCarryforwardRequestRepository.save(acceptCarryforwardRequest);
		return true;
	}

	@Override
	public boolean editAcceptCarryforwardRequest(Integer id, AcceptCarryforwardRequest acceptCarryforwardRequest) {
		if (acceptCarryforwardRequestRepository.getOne(id) != null) {
			acceptCarryforwardRequest.setId(id);
			acceptCarryforwardRequestRepository.save(acceptCarryforwardRequest);
			return true;
		}
		return false;
	}

	@Override
	public List<AcceptCarryforwardRequest> getAllAcceptCarryforwardRequests() {
		return acceptCarryforwardRequestRepository.findAll();
	}

	@Override
	public AcceptCarryforwardRequest getAcceptCarryforwardRequest(Integer id) {
		return acceptCarryforwardRequestRepository.findById(id).orElse(null);
	}
	@Override
	public boolean deleteAcceptCarryforwardRequest(Integer id) {
		if (acceptCarryforwardRequestRepository.getOne(id) != null) {
			acceptCarryforwardRequestRepository.deleteById(id);
			return true;
		}
		return false;
	}
	}
	


