package com.sgic.hrm.trainee.service;

import java.util.List;
import com.sgic.hrm.commons.entity.trainee.TraineeAcademicQualification;
import com.sgic.hrm.commons.entity.trainee.TraineeExamType;
import com.sgic.hrm.commons.entity.trainee.Trainee;

public interface TraineeAcademicQualificationService {
	boolean addAcademicQualification(TraineeAcademicQualification traineeAcademicQualification,
			TraineeExamType traineeExamType, Trainee trainee);

	List<TraineeAcademicQualification> getAllAcademicQualification();

	boolean editAcademicQualification(TraineeAcademicQualification traineeAcademicQualification,
			TraineeExamType traineeExamType, Trainee trainee, Integer id);

	boolean deleteAcademicQualification(Integer id);

	TraineeAcademicQualification getAcademicQualificationById(int id);

	List<TraineeAcademicQualification> getAcademicQualificationByTraineeId(Integer uid);
}
