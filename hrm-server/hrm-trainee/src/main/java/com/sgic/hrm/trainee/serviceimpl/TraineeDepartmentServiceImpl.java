package com.sgic.hrm.trainee.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.trainee.TraineeDepartment;
import com.sgic.hrm.commons.repository.trainee.TraineeDepartmentRepository;
import com.sgic.hrm.trainee.service.TraineeDepartmentService;

@Service
public class TraineeDepartmentServiceImpl implements TraineeDepartmentService {
	@Autowired
	private TraineeDepartmentRepository traineeDepartmentRepository;

	@Override
	public boolean addDepartment(TraineeDepartment traineeDepartment) {
		traineeDepartmentRepository.save(traineeDepartment);
		return true;
	}

	@Override
	public List<TraineeDepartment> getAllDepartment() {
		return traineeDepartmentRepository.findAll();
	}

	@Override
	public boolean editDepartment(TraineeDepartment traineeDepartment, int id) {
		if (traineeDepartmentRepository.getOne(id) != null) {
			traineeDepartmentRepository.save(traineeDepartment);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteDepartment(int id) {
		if (traineeDepartmentRepository.getOne(id) != null) {
			traineeDepartmentRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public TraineeDepartment findByDepartmentId(Integer id) {
		return traineeDepartmentRepository.findDepartmentById(id);
	}

}
