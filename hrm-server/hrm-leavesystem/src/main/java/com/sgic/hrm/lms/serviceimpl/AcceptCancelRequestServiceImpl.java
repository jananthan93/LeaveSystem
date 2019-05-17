package com.sgic.hrm.lms.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.AcceptCancelRequest;
import com.sgic.hrm.commons.repository.AcceptCancelRequestRepository;
import com.sgic.hrm.lms.service.AcceptCancelRequestService;

@Service
public class AcceptCancelRequestServiceImpl implements AcceptCancelRequestService {

	@Autowired
	AcceptCancelRequestRepository acceptCancelRequestRepository;

	@Override
	public boolean addAcceptCancelRequest(AcceptCancelRequest acceptCancelRequest) {
		acceptCancelRequestRepository.save(acceptCancelRequest);
		return true;
	}

	@Override
	public boolean editAcceptCancelRequest(Integer id, AcceptCancelRequest acceptCancelRequest) {
		if (acceptCancelRequestRepository.getOne(id) != null) {
			acceptCancelRequest.setId(id);
			acceptCancelRequestRepository.save(acceptCancelRequest);
			return true;
		}
		return false;
	}

	@Override
	public List<AcceptCancelRequest> getAllAcceptCancelRequests() {
		return acceptCancelRequestRepository.findAll();

	}

	@Override
	public AcceptCancelRequest getAcceptCancelRequest(Integer id) {
		return acceptCancelRequestRepository.findById(id).orElse(null);
	}

	@Override
	public boolean deleteAcceptCancelRequest(Integer id) {
		if (acceptCancelRequestRepository.getOne(id) != null) {
			acceptCancelRequestRepository.deleteById(id);
			return true;
		}
		return false;
	}

}
