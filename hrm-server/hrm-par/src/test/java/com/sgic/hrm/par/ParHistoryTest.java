package com.sgic.hrm.par;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sgic.hrm.par.service.ParService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParHistoryTest {
	@Autowired
	ParService parService;

	@Test
	public void Parhistory() {
		// List<Par>par =new ArrayList<>();
		System.out.println(parService.parHistory());

	}

	@Test
	public void ParHistoryFindByEmpId1() {
		assertNotNull(parService.findByEmployeeId("EM002"));

	}

	@Test
	public void ParHistoryFindByEmpId2() {
		assertNotNull(parService.findByEmployeeId("123"));

	}
}