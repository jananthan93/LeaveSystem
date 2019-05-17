package com.sgic.hrm.par.service;

import java.util.List;

import com.sgic.hrm.commons.entity.par.ReportParAppraisor;
import com.sgic.hrm.commons.entity.par.ScoreParAppraisor;

public interface ScoreParAppraisorService {
	public void createScoreParAppraisor(ScoreParAppraisor scoreParAppraisor,ReportParAppraisor reportParAppraisor );

	public List<ScoreParAppraisor> getScore(ReportParAppraisor reportParAppraisor);
}
