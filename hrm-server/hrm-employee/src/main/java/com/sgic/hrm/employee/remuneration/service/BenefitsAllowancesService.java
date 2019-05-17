package com.sgic.hrm.employee.remuneration.service;

import java.util.List;

import com.sgic.hrm.commons.entity.IndividualWelfare;

public interface BenefitsAllowancesService {

	List<IndividualWelfare> getBenefitsAllowances();

	IndividualWelfare viewById(Integer id);

//	List<IndividualWelfare> viewByChatId(Integer id);
	
	IndividualWelfare viewByWelfareEventId(Integer id);
}
