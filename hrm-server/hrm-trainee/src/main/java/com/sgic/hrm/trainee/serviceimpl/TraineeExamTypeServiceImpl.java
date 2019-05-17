package com.sgic.hrm.trainee.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.hrm.commons.entity.trainee.TraineeExamType;
import com.sgic.hrm.commons.repository.trainee.TraineeExamTypeRepository;
import com.sgic.hrm.trainee.service.TraineeExamTypeService;

@Service
public class TraineeExamTypeServiceImpl implements TraineeExamTypeService {
	@Autowired
	private TraineeExamTypeRepository traineeExamTypeRepository;

	@Override
	public boolean addExamType(TraineeExamType examtype) {
		traineeExamTypeRepository.save(examtype);
		return true;
	}

	@Override
	public List<TraineeExamType> getAllExamType() {
		return traineeExamTypeRepository.findAll();
	}

	@Override
	public TraineeExamType findByExamTypeId(Integer id) {
		return traineeExamTypeRepository.findExamTypeById(id);
	}

	@Override
	public boolean editExamType(TraineeExamType examtype, Integer id) {
		if (traineeExamTypeRepository.getOne(id) != null) {
			examtype.setId(id);
			traineeExamTypeRepository.save(examtype);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteExamType(Integer id) {
		if (traineeExamTypeRepository.getOne(id) != null) {
			traineeExamTypeRepository.deleteById(id);
		}
		return false;
	}

}
