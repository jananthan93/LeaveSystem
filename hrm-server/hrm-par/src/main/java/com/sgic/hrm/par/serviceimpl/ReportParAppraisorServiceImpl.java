package com.sgic.hrm.par.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.par.Par;
import com.sgic.hrm.commons.entity.par.ReportParAppraisor;
import com.sgic.hrm.commons.repository.par.ReportParAppraisorRepository;
import com.sgic.hrm.par.service.ReportParAppraisorService;

@Service
public class ReportParAppraisorServiceImpl implements ReportParAppraisorService {
	@Autowired
	ReportParAppraisorRepository reportParAppraisorRepo;

	@Override
	public void createReportParAppraise(ReportParAppraisor reportParAppraisor, Par par) {
		// TODO Auto-generated method stub
		reportParAppraisor.setPar(par);
		reportParAppraisorRepo.save(reportParAppraisor);

	}

	@Override
	public ReportParAppraisor findReportParAppraisorById(String reportId) {
		
		return reportParAppraisorRepo.findReportParAppraiseById(reportId);
	}

	@Override
	public List<ReportParAppraisor> findReportParAppraiserByPar(Par par) {
		// TODO Auto-generated method stub
		return reportParAppraisorRepo.findReportParAppraisorByPar(par);
	}

}