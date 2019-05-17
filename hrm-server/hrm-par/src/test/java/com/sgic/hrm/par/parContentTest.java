package com.sgic.hrm.par;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sgic.hrm.commons.entity.par.ParContent;
import com.sgic.hrm.par.service.ParContentService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class parContentTest {

	@Autowired
	ParContentService parContentService;

	@Test
	public void saveParContentTest1() {
		parContentService.createParContent(new ParContent(1,"Communication"));

	}

	@Test
	public void saveParContentTest2() {
		parContentService.createParContent(new ParContent(2, "Technical"));
	}

	@Test
	public void saveParContentTest3() {
		parContentService.createParContent(new ParContent(3, "Attitude"));
	}

	@Test
	public void saveParContentTest4() {
		parContentService.createParContent(new ParContent(4, "Personality"));
	}
	
	@Test
	public void saveParContentTest5() {
		parContentService.createParContent(new ParContent(5, "Punctuality"));
	}
}