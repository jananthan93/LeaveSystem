//code done by jayapriya
package com.sgic.hrm.trainer.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.trainer.PreRequest;
import com.sgic.hrm.commons.trainer.repository.PreRequestRepository;
import com.sgic.hrm.trainer.service.PreRequestService;
@Service
public class PreRequestServiceImpl implements PreRequestService{
	
	@Autowired PreRequestRepository preRequestRepository;

	@Override
	public boolean addPreRequest(PreRequest preRequest) {
		preRequestRepository.save(preRequest);
		return true;
	}

	@Override
	public boolean editPreRequest(Integer id, PreRequest preRequest) {
		if(preRequestRepository.getOne(id)!=null) {
			preRequest.setId(id);
			preRequestRepository.save(preRequest);
			return true;
		}
		return false;
	}

	@Override
	public boolean deletePreRequest(Integer id) {
		preRequestRepository.deleteById(id);
		return true;
	}

	@Override
	public List<PreRequest> getAllPreRequest() {
		
		return preRequestRepository.findAll();
	}

	@Override
	public PreRequest getPreRequestById(Integer id) {
		
		return preRequestRepository.findById(id).orElse(null);
	}

}
