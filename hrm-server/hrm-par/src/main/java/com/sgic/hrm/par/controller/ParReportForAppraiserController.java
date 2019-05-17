package com.sgic.hrm.par.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.hrm.commons.dto.par.ParAppraisorDto;
import com.sgic.hrm.commons.dto.par.ReportParAppraisorDtoGet;
import com.sgic.hrm.commons.dto.par.ReportParAppraisorDtoPost;
import com.sgic.hrm.commons.dto.par.ScoreParAppraiserDtoGet;
import com.sgic.hrm.commons.dto.par.ScoreParAppraiserDtoPost;
import com.sgic.hrm.par.serviceCombined.ParReportForAppraisorService;

@CrossOrigin
@RestController
public class ParReportForAppraiserController {

	@Autowired
	ParReportForAppraisorService parReportForAppraisorService;

	@GetMapping("/parReportAppraiserTemplatePost")
	public ReportParAppraisorDtoPost getParReportForAppraiseePost() {
		ReportParAppraisorDtoPost reportParAppraiserDtoPost = new ReportParAppraisorDtoPost();

		List<ScoreParAppraiserDtoPost> scoreParAppraisorList = new ArrayList<>();
		scoreParAppraisorList.add(new ScoreParAppraiserDtoPost());
		scoreParAppraisorList.add(new ScoreParAppraiserDtoPost());
		reportParAppraiserDtoPost.setScoreParAppraiserList(scoreParAppraisorList);
		return reportParAppraiserDtoPost;
	}

	@PutMapping("/parReportAppraiser/{parId}")
	public String createParReportForAppraisee(@RequestBody ReportParAppraisorDtoPost reportParAppraiserDtoPost,@PathVariable("parId") Integer parId ) {

		return parReportForAppraisorService.saveReportAndScoreAppraisor(reportParAppraiserDtoPost,parId);
	}

	@GetMapping("/parReportAppraiserTemplateGet")
	public ReportParAppraisorDtoGet getParReportForAppraiseeGet() {
		ReportParAppraisorDtoGet reportParAppraiseeDtoGet = new ReportParAppraisorDtoGet();
		ParAppraisorDto appraisorDto = new ParAppraisorDto();
		reportParAppraiseeDtoGet.setAppraisedBy(appraisorDto);
		List<ScoreParAppraiserDtoGet> scoreParAppraisorList = new ArrayList<>();
		scoreParAppraisorList.add(new ScoreParAppraiserDtoGet());
		scoreParAppraisorList.add(new ScoreParAppraiserDtoGet());
		scoreParAppraisorList.add(new ScoreParAppraiserDtoGet());
		reportParAppraiseeDtoGet.setScoreParAppraiserList(scoreParAppraisorList);
		return reportParAppraiseeDtoGet;
	}

	@GetMapping("/parReportAppraiser/{parId}")
	public List<ReportParAppraisorDtoGet> getParReportForAppraiseeByParId(@PathVariable("parId") Integer parId) {
		return parReportForAppraisorService.getParReportForAppraiserByParId(parId);
	}
}
