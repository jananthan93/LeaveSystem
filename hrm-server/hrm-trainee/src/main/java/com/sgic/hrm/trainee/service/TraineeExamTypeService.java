package com.sgic.hrm.trainee.service;

import java.util.List;
import com.sgic.hrm.commons.entity.trainee.TraineeExamType;

public interface TraineeExamTypeService {
	boolean addExamType(TraineeExamType examtype);

	List<TraineeExamType> getAllExamType();

	TraineeExamType findByExamTypeId(Integer id);

	boolean editExamType(TraineeExamType examtype, Integer id);

	boolean deleteExamType(Integer id);
}
