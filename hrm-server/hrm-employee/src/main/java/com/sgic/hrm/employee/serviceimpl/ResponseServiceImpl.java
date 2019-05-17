package com.sgic.hrm.employee.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.Response;
import com.sgic.hrm.commons.repository.LoginRepository;
import com.sgic.hrm.commons.repository.ResponseRepository;
import com.sgic.hrm.employee.service.ResponseService;

@Service
public class ResponseServiceImpl implements ResponseService {

	@Autowired
	private ResponseRepository responseRepository;
	
	@Autowired
	private LoginRepository loginRepository;
	
	@Override
	public List<Response> viewResponse() {
		return responseRepository.findAll();
	}

	@Override
	public boolean addResponse(Response response) {
		responseRepository.save(response);
		return true;
	}

	@Override
	public List<Response> getSpecificUser(String name) {
		return responseRepository.findByRelevantIndividual(loginRepository.findByUsername(name).get().getUser());
	}

}
