package com.sgic.hrm.par.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.par.ReportParAppraisor;
import com.sgic.hrm.commons.entity.par.ScoreParAppraisor;
import com.sgic.hrm.commons.repository.par.ScoreParAppraisorRepository;
import com.sgic.hrm.par.service.ScoreParAppraisorService;


@Service
public class ScoreParAppraisorServiceImpl implements  ScoreParAppraisorService {
@Autowired
ScoreParAppraisorRepository scoreParAppraisorRepo;
	@Override
	public void createScoreParAppraisor(ScoreParAppraisor scoreParAppraisor, ReportParAppraisor reportParAppraisor) {
		// TODO Auto-generated method stub
		scoreParAppraisor.setReportParAppraisor(reportParAppraisor);
		scoreParAppraisorRepo.save(scoreParAppraisor);
		
	}
	@Override
	public List<ScoreParAppraisor> getScore(ReportParAppraisor reportParAppraisor) {
		// TODO Auto-generated method stub
		return scoreParAppraisorRepo.findScoreParAppraisorByReportParAppraisor(reportParAppraisor);
	}

}
