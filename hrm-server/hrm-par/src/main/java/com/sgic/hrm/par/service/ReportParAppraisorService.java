package com.sgic.hrm.par.service;

import java.util.List;

import com.sgic.hrm.commons.entity.par.Par;
import com.sgic.hrm.commons.entity.par.ReportParAppraisor;

public interface ReportParAppraisorService {
	public void createReportParAppraise(ReportParAppraisor reportParAppraisor,Par par);

	public ReportParAppraisor findReportParAppraisorById(String pk);

	public List<ReportParAppraisor> findReportParAppraiserByPar(Par par);
	
}