package com.sgic.hrm.trainer;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

import java.util.List;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sgic.hrm.commons.entity.trainer.Payment;
import com.sgic.hrm.trainer.service.PaymentService;
import com.sgic.hrm.trainer.service.TrainingScheduleService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HrmTrainerApplicationPaymentTest {

	@Autowired
	PaymentService paymentService;
	
	@Autowired
	TrainingScheduleService trainingScheduleService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddPayment() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllPayment() {
		List<Payment> test = paymentService.getAllPayment();
		assertThat(test, not(IsEmptyCollection.empty()));
	}

	@Test
	public void testEditPayment() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeletePayment() {
		fail("Not yet implemented");
	}

}
