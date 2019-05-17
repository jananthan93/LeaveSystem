package com.sgic.hrm.trainee.service;

import java.util.List;
import java.util.Optional;

import com.sgic.hrm.commons.entity.trainee.TraineeProfessionalQualification;
import com.sgic.hrm.commons.entity.trainee.Trainee;

public interface TraineeProfessionalQualificationService {

	List<TraineeProfessionalQualification> getAllProofessionalQualificstion();

	public boolean addProfessionalQualification(TraineeProfessionalQualification traineeProfessionalQualification,
			Trainee trainee);

	public boolean editProfessionalQualification(Integer id,
			TraineeProfessionalQualification traineeProfessionalQualification, Trainee trainee);

	public boolean deleteProfessionalQualification(Integer id);

	Optional<TraineeProfessionalQualification> getProfessionalQualificationalById(int id);

	List<TraineeProfessionalQualification> getProfessionalQualificationByTraineeId(int tid);
}
