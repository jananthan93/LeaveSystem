package com.sgic.hrm.par;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sgic.hrm.commons.entity.par.ParAppraisor;
import com.sgic.hrm.par.service.ParAppraisorService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class parAppraisorsTest {

	@Autowired
	ParAppraisorService  parAppraisorService;
	
	@Test
	public void saveParAppraisorTest1() {
		parAppraisorService.createParAppraisor(new ParAppraisor(1,"EMX001","Alan"));
	}
	
	@Test
	public void saveParAppraisorTest2() {
		parAppraisorService.createParAppraisor(new ParAppraisor(2,"EMX002","Suja"));
	}
	
	@Test
	public void saveParAppraisorTest3() {
		parAppraisorService.createParAppraisor(new ParAppraisor(3,"EMX003","Betsy"));
	}
	
	@Test
	public void saveParAppraisorTest4() {
		parAppraisorService.createParAppraisor(new ParAppraisor(4,"EMX004","Noel"));
	}
}