package com.sgic.hrm.employee.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.RejectedApplicant;
import com.sgic.hrm.commons.repository.RejectedApplicantRepository;
import com.sgic.hrm.employee.service.RejectedApplicantService;
@Service
public class RejectedApplicantServiceImpl implements RejectedApplicantService{

	@Autowired
	private RejectedApplicantRepository rejectedApplicantRepository;
	@Override
	public boolean addRejectedApplicant(RejectedApplicant rejectedApplicant) {
		rejectedApplicantRepository.save(rejectedApplicant);
		return true;
	}

	@Override
	public List<RejectedApplicant> getAllRejectedApplicant() {
		return rejectedApplicantRepository.findAll();
	}

	@Override
	public boolean editRejectedApplicant(RejectedApplicant rejectedApplicant, Integer id) {
		boolean success = false;
		if (rejectedApplicantRepository.getOne(id) != null) {
			rejectedApplicant.setId(id);
			rejectedApplicantRepository.save(rejectedApplicant);
			success = true;
			return success;
		}
		return success;
	}

	@Override
	public boolean deleteRejectedApplicant(Integer id) {
		RejectedApplicant rejectedApplicant = rejectedApplicantRepository.getOne(id);
		if (rejectedApplicant.getId() == (id)) {
			rejectedApplicantRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public RejectedApplicant getById(Integer id) {
		return rejectedApplicantRepository.getOne(id);
	}

}
