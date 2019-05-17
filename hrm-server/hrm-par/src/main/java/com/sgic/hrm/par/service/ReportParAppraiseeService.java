package com.sgic.hrm.par.service;

import com.sgic.hrm.commons.entity.par.Par;
import com.sgic.hrm.commons.entity.par.ReportParAppraise;

public interface ReportParAppraiseeService {
	public void createReportParAppraise(ReportParAppraise reportParAppraise,Par par);
	public ReportParAppraise findReportParAppraiseeById(Integer id);
	
	public ReportParAppraise findReportParAppraiseeByPar(Par par);
}