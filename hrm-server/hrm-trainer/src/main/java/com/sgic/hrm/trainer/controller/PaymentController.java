package com.sgic.hrm.trainer.controller;
//Created by Thamilini
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.hrm.commons.entity.trainer.Payment;
import com.sgic.hrm.commons.trainer.dto.PaymentData;
import com.sgic.hrm.commons.trainer.dto.PaymentSaveData;
import com.sgic.hrm.commons.trainer.dto.mapper.PaymentDataMapper;
import com.sgic.hrm.trainer.service.PaymentService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController

public class PaymentController {
	@Autowired
	private PaymentService paymentService;

	@GetMapping("/payment")
	public ResponseEntity<List<Payment>> getPayment() {
		List<Payment> payment = paymentService.getAllPayment();
		ResponseEntity<List<Payment>> response = new ResponseEntity<>(payment, HttpStatus.OK);
		return response;
	}

	@PostMapping("/payment")
	public HttpStatus postPayment(@RequestBody PaymentSaveData paymentSaveData) {

		boolean test = paymentService.addPayment(PaymentDataMapper.paymentSaveDataMapper(paymentSaveData));
		if (test) {
			return HttpStatus.CREATED;
		}
		return HttpStatus.BAD_REQUEST;
	}

	@PutMapping("/payment/{id}")
	public ResponseEntity<String> updatePayment(@PathVariable(name = "id") Integer id,
			@RequestBody PaymentData paymentData) {
		Payment payment = PaymentDataMapper.paymentDataMapper(paymentData);
		if (paymentService.editPayment(payment, id)) {
			return new ResponseEntity<>("updated", HttpStatus.OK);
		}
		return new ResponseEntity<>("upadte failed", HttpStatus.BAD_REQUEST);

	}

	@DeleteMapping("/payment/{id}")
	public HttpStatus deletePayment(@PathVariable("id") Integer payment_id) {
		boolean test = paymentService.deletePayment(payment_id);
		HttpStatus status;
		if (test) {
			return HttpStatus.OK;
		} else {
			status = HttpStatus.BAD_REQUEST;
		}
		return status;
	}

//	@GetMapping("/paymentByTrainer/{id}")
//	public List<Payment> getAllPaymentByTrainerId(@PathVariable int id) {
//		return paymentService.getPaymentByTrainerId(id);
//	}

//	@GetMapping("/payment/{id1}")
//	public List<Payment> getOneById(@PathVariable("id1") Integer payment_id) {
//		return paymentService.getById(payment_id);
//	}
}
