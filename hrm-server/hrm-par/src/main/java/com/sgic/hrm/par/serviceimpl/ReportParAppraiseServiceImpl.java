package com.sgic.hrm.par.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.par.Par;
import com.sgic.hrm.commons.entity.par.ReportParAppraise;
import com.sgic.hrm.commons.repository.par.ReportParAppraiseRepository;
import com.sgic.hrm.par.service.ReportParAppraiseeService;



@Service
public class ReportParAppraiseServiceImpl implements ReportParAppraiseeService
{

	@Autowired
	ReportParAppraiseRepository reportParAppraiseRepo;
	
	public void createReportParAppraise(ReportParAppraise reportParAppraise,Par par) {
	
			reportParAppraise.setPar(par);
			reportParAppraiseRepo.save(reportParAppraise);
		
	}

	@Override
	public ReportParAppraise findReportParAppraiseeById(Integer id) {
		// TODO Auto-generated method stub
		return reportParAppraiseRepo.findReportParAppraiseById(id);
	}

	

	@Override
	public ReportParAppraise findReportParAppraiseeByPar(Par par) {
		// TODO Auto-generated method stub
		return reportParAppraiseRepo.findReportParAppraiseByPar(par);
	}
}