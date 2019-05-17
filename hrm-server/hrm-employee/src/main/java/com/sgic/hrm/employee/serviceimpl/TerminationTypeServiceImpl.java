package com.sgic.hrm.employee.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.TerminationType;
import com.sgic.hrm.commons.repository.TerminationTypeRepository;
import com.sgic.hrm.employee.service.TerminationTypeService;

@Service
public class TerminationTypeServiceImpl implements TerminationTypeService{
	@Autowired
	TerminationTypeRepository terminationTypeRepository;

	@Override
	public boolean addTerminationType(TerminationType terminationType) {
		terminationTypeRepository.save(terminationType);
		return true;
	}

	@Override
	public List<TerminationType> getAllTerminationType() {
		
		return terminationTypeRepository.findAll();
	}

	@Override
	public boolean editTerminationType(TerminationType terminationType, Integer id) {
		if(terminationTypeRepository.getOne(id)!=null) {
			terminationType.setId(id);
			terminationTypeRepository.save(terminationType);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteTerminationType(Integer id) {
		terminationTypeRepository.deleteById(id);
		return true;
	}

	@Override
	public TerminationType getById(Integer id) {
		
		return terminationTypeRepository.findById(id).orElse(null);
	}

}
