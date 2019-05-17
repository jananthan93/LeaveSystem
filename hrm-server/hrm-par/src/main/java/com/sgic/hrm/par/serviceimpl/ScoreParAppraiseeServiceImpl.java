package com.sgic.hrm.par.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.par.ReportParAppraise;
import com.sgic.hrm.commons.entity.par.ScoreParAppraisee;
import com.sgic.hrm.commons.repository.par.ScoreParAppraiseeRepository;
import com.sgic.hrm.par.service.ScoreParAppraiseeService;

@Service
public class ScoreParAppraiseeServiceImpl implements ScoreParAppraiseeService {
	@Autowired
	ScoreParAppraiseeRepository scoreParAppraiseeRepo;

	@Override
	public void createScoreParAppraisee(ScoreParAppraisee scoreParAppraisee, ReportParAppraise reportParAppraise) {
		scoreParAppraisee.setReportParAppraise(reportParAppraise);
		scoreParAppraiseeRepo.save(scoreParAppraisee);

	}

	@Override
	public List<ScoreParAppraisee> getScore(ReportParAppraise reportParAppraise) {
		// TODO Auto-generated method stub
		return scoreParAppraiseeRepo.findScoreParAppraiseeByReportParAppraise(reportParAppraise);
	}

}
