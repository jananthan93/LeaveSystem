package com.sgic.hrm.par;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sgic.hrm.commons.dto.par.ReportParAppraisorDtoPost;
import com.sgic.hrm.commons.dto.par.ScoreParAppraiserDtoPost;
import com.sgic.hrm.par.serviceCombined.ParReportForAppraisorService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParReportAppraisorTest {
	@Autowired
	ParReportForAppraisorService parReportForAppraisorService;
	@Test
	public void  ParReportAppraisor1() {
//		ReportParAppraisorDtoPost objParReport =new ReportParAppraisorDtoPost(1,1,"c1",new Date());
//		List<ScoreParAppraiserDtoPost> scoreParAppraisorList=new ArrayList<>();
//		scoreParAppraisorList.add(new ScoreParAppraiserDtoPost("1",3.5));
//		scoreParAppraisorList.add(new ScoreParAppraiserDtoPost("2",2.5));
//		scoreParAppraisorList.add(new ScoreParAppraiserDtoPost("3",1.5));
//		objParReport.setScoreParAppraiserList(scoreParAppraisorList);
//		parReportForAppraisorService.saveReportAndScoreAppraisor(objParReport);
	}
	
	@Test
	public void  ParReportAppraisor2() {
//		ReportParAppraisorDtoPost objParReport =new ReportParAppraisorDtoPost(2,1,"c2",new Date());
//		List<ScoreParAppraiserDtoPost> scoreParAppraisorList=new ArrayList<>();
//		scoreParAppraisorList.add(new ScoreParAppraiserDtoPost("1",3.5));
//		scoreParAppraisorList.add(new ScoreParAppraiserDtoPost("2",2.5));
//		scoreParAppraisorList.add(new ScoreParAppraiserDtoPost("3",1.5));
//		objParReport.setScoreParAppraiserList(scoreParAppraisorList);
//		parReportForAppraisorService.saveReportAndScoreAppraisor(objParReport);
	}

}