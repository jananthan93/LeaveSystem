package com.sgic.hrm.employee.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.RecruitmentType;
import com.sgic.hrm.commons.repository.RecruitmentTypeRepository;
import com.sgic.hrm.employee.service.RecruitmentTypeService;



@Service
public class RecuitmentTypeServiceImpl implements RecruitmentTypeService {
	@Autowired
	private RecruitmentTypeRepository recruitmentRepository;

	@Override
	public boolean addRecruitment(RecruitmentType recruitment) {
		recruitmentRepository.save(recruitment);
		return true;
	}

	@Override
	public List<RecruitmentType> getAllRecruitment() {
		return recruitmentRepository.findAll();
	}

	@Override
	public boolean editRecruitment(RecruitmentType recruitment, Integer id) {
		boolean success = false;
		if (recruitmentRepository.getOne(id) != null) {
			recruitment.setId(id);
			recruitmentRepository.save(recruitment);
			success = true;
			return success;
		}
		return success;
	}

	@Override
	public boolean deleteRecruitment(Integer id) {
		RecruitmentType recuitment = recruitmentRepository.getOne(id);
		if (recuitment.getId() == (id)) {
			recruitmentRepository.deleteById(id);
			return true;
		}
		return false;
	}

	
}
