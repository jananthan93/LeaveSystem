package com.sgic.hrm.trainer.serviceimpl;

//done by_Sujaany
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.trainer.RecordOfEmployment;
import com.sgic.hrm.commons.trainer.repository.RecordOfEmploymentRepository;
import com.sgic.hrm.trainer.service.RecordOfEmploymentService;

@Service
public class RecordOfEmployeeServiceImpl implements RecordOfEmploymentService {
	@Autowired
	private RecordOfEmploymentRepository recordOfEmploymentRepository;

	@Override
	public List<RecordOfEmployment> getAllRecordOfEmployment() {
		return recordOfEmploymentRepository.findAll();
	}

	@Override
	public boolean createRecordOfEmployment(RecordOfEmployment recordOfEmployment) {
		recordOfEmploymentRepository.save(recordOfEmployment);
		return true;
	}

	@Override
	public boolean deleteRecordOfEmployment(Integer id) {
		recordOfEmploymentRepository.deleteById(id);
		return true;
	}

	@Override
	public boolean updateRecordOfEmployment(RecordOfEmployment recordOfEmployment, Integer id) {
		if (recordOfEmploymentRepository.getOne(id) != null) {
			recordOfEmployment.setId(id);
			recordOfEmploymentRepository.save(recordOfEmployment);
			return true;
		}
		return false;
	}

	@Override
	public RecordOfEmployment getById(Integer id) {
		return recordOfEmploymentRepository.findById(id).orElse(null);
	}
}
