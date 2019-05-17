package com.sgic.hrm.employee.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.IndividualWelfare;
import com.sgic.hrm.commons.repository.IndividualWelfareRepository;

import com.sgic.hrm.employee.service.IndividualWelfareService;

@Service
public class IndividualWelfareServiceImpl implements IndividualWelfareService {
	
	@Autowired
	private IndividualWelfareRepository individualWelfareRepository;

	@Override
	public List<IndividualWelfare> getAllIndividualWelfare() {
		return individualWelfareRepository.findAll();
	}

	
	@Override
	public boolean createIndividualWelfare(IndividualWelfare individualWelfare) {
		individualWelfareRepository.save(individualWelfare);
		return true;
		
	}
	
	@Override
	public boolean updateIndividualWelfare(IndividualWelfare individualWelfare, Integer id) {
		IndividualWelfare existIndividualWelfare =individualWelfareRepository.getOne(id);
		
		if(existIndividualWelfare.getId() !=null) {
			individualWelfare.setId(id);
			individualWelfareRepository.save(individualWelfare);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteIndividualWelfare(Integer id) {
		individualWelfareRepository.deleteById(id);
		return true;
		
	}


	@Override
	public IndividualWelfare getById(Integer id) {
		return individualWelfareRepository.findById(id).orElse(null);
	}


	
}

