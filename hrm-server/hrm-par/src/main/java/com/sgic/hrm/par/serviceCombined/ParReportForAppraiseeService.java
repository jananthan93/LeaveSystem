package com.sgic.hrm.par.serviceCombined;

import com.sgic.hrm.commons.dto.par.ReportParAppraiseeDtoGet;
import com.sgic.hrm.commons.dto.par.ReportParAppraiseeDtoPost;

public interface ParReportForAppraiseeService {


	/*
	 * save report entity -save list of par score -save report record find the par
	 * object by par id save the ReportParAppraise including par object write
	 * iteratoror to save the List of ScoreParAppraisee
	 */
	
	public String saveReportAndScore(ReportParAppraiseeDtoPost reportParAppraiseeDtoPost,Integer parId);

	// update one par score
	public boolean updateParScore();

	public ReportParAppraiseeDtoGet getReportAndScore(Integer parId);
}