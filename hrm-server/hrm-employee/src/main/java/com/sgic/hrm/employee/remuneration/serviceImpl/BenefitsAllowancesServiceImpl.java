package com.sgic.hrm.employee.remuneration.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.IndividualWelfare;
import com.sgic.hrm.commons.repository.IndividualWelfareRepository;
import com.sgic.hrm.employee.remuneration.service.BenefitsAllowancesService;

@Service
public class BenefitsAllowancesServiceImpl implements BenefitsAllowancesService {

//	@Autowired
//	BenefitsAllowancesRepository benefitsAllowancesRepository;

	@Autowired
	IndividualWelfareRepository individualWelfareRepository;

	@Override
	public List<IndividualWelfare> getBenefitsAllowances() {
		// TODO Auto-generated method stub
		return individualWelfareRepository.findAll();
	}

	@Override
	public IndividualWelfare viewById(Integer id) {
		// TODO Auto-generated method stub
		return individualWelfareRepository.getOne(id);
	}

	@Override
	public IndividualWelfare viewByWelfareEventId(Integer id) {
		// TODO Auto-generated method stub

		return individualWelfareRepository.findByWelfareEventId(id);
	}



}
