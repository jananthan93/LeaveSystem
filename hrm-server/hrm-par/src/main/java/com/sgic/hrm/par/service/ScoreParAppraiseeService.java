package com.sgic.hrm.par.service;

import java.util.List;

import com.sgic.hrm.commons.entity.par.ReportParAppraise;
import com.sgic.hrm.commons.entity.par.ScoreParAppraisee;

public interface ScoreParAppraiseeService {
	public void createScoreParAppraisee(ScoreParAppraisee scoreParAppraisee,ReportParAppraise reportParAppraise );
	
	public List<ScoreParAppraisee> getScore(ReportParAppraise reportParAppraise);
}
