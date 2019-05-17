package com.sgic.hrm.par.service;

import java.util.List;

import com.sgic.hrm.commons.entity.par.ParAppraisor;

public interface ParAppraisorService {

	public List<ParAppraisor> getParAppraisor();

	public void createParAppraisor(ParAppraisor parAppraisor);

	public void updateParAppraisor(ParAppraisor parAppraisor, Integer id);

	public void deleteParAppraisor(Integer id);
	
	public ParAppraisor findParAppraisorByAppraiserId(Integer appraiserId);

}
