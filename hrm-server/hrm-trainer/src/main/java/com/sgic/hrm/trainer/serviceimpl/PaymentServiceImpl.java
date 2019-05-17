package com.sgic.hrm.trainer.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.hrm.commons.entity.trainer.Payment;
import com.sgic.hrm.commons.trainer.repository.PaymentRepository;
import com.sgic.hrm.trainer.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public boolean addPayment(Payment payment) {
		paymentRepository.save(payment);
		return true;
	}

	@Override
	public List<Payment> getAllPayment() {
		return paymentRepository.findAll();
	}

	@Override
	public boolean editPayment(Payment payment, Integer id) {
		boolean success = false;
		if (paymentRepository.getOne(id) != null) {
			payment.setId(id);
			paymentRepository.save(payment);
			success = true;
			return success;
		}
		return success;
	}

	@Override
	public boolean deletePayment(Integer id) {
		Payment payment = paymentRepository.getOne(id);
		if (payment.getId() == (id)) {
			paymentRepository.deleteById(id);
			return true;
		}
		return false;
	}

//	@Override
//	public List<Payment> getById(Integer id) {
//		return paymentRepository.getOne(id)
//		}

//	@Override
//	public List<Payment> getPaymentByTrainerId(int id) {
//		return paymentRepository.findByTrainerId(id);
//	}

}
