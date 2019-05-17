package com.sgic.hrm.par;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sgic.hrm.commons.dto.par.ReportParAppraiseeDtoPost;
import com.sgic.hrm.commons.dto.par.ScoreParAppraiseeDtoPost;
import com.sgic.hrm.par.service.ReportParAppraiseeService;
import com.sgic.hrm.par.serviceCombined.ParReportForAppraiseeService;



@RunWith(SpringRunner.class)
@SpringBootTest
public class ParReportTest {
	@Autowired
	ParReportForAppraiseeService parReportForAppraiseeService;
	@Autowired
	ReportParAppraiseeService reportParAppraiseeService;
	
	@Test
	public void parReportTest1() {
//		ReportParAppraiseeDtoPost objParReport = new ReportParAppraiseeDtoPost(2,1);
//	List<ScoreParAppraiseeDtoPost> scheduleParAppraisorList=new ArrayList<ScoreParAppraiseeDtoPost>();
//	scheduleParAppraisorList.add(new ScoreParAppraiseeDtoPost("C001",3.00));
//	scheduleParAppraisorList.add(new ScoreParAppraiseeDtoPost("C002",4.00));
//	scheduleParAppraisorList.add(new ScoreParAppraiseeDtoPost("C003",5.00));
//	scheduleParAppraisorList.add(new ScoreParAppraiseeDtoPost("C004",5.00));
//	objParReport.setScoreParAppraiseeList(scheduleParAppraisorList);
//	parReportForAppraiseeService.saveReportAndScore(objParReport);
	
	}
	
	@Test 
	public void parReportTest2() {
		assertNotNull(reportParAppraiseeService.findReportParAppraiseeById(1));
		
	}
	
	@Test 
	public void parReportTest3() {
		assertNotNull(reportParAppraiseeService.findReportParAppraiseeById(4));
		
	}
}