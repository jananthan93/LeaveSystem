package com.sgic.hrm.par.serviceCombined;

import java.util.List;

import com.sgic.hrm.commons.dto.par.ReportParAppraisorDtoGet;
import com.sgic.hrm.commons.dto.par.ReportParAppraisorDtoPost;

public interface ParReportForAppraisorService {
	/*
	 * save report entity -save list of par score -save report record find the par
	 * object by par id save the ReportParAppraise including par object write
	 * iteratoror to save the List of ScoreParAppraisee
	 */
	public String saveReportAndScoreAppraisor(ReportParAppraisorDtoPost reportParAppraisorDtoPost, Integer parId);

	public List<ReportParAppraisorDtoGet> getParReportForAppraiserByParId(Integer parId);

}