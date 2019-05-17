package com.sgic.hrm.trainee.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.trainee.TraineeProfessionalQualification;
import com.sgic.hrm.commons.entity.trainee.Trainee;
import com.sgic.hrm.commons.repository.trainee.TraineeProfessionalQualificationRepository;
import com.sgic.hrm.commons.repository.trainee.TraineeRepository;
import com.sgic.hrm.trainee.service.TraineeProfessionalQualificationService;

@Service
public class TraineeProfessionalQualificationServiceImpl implements TraineeProfessionalQualificationService {
	@Autowired
	private TraineeProfessionalQualificationRepository traineeProfessionalQualificationRepository;
	@Autowired
	private TraineeRepository traineeRepository;

	@Override
	public List<TraineeProfessionalQualification> getAllProofessionalQualificstion() {
		return traineeProfessionalQualificationRepository.findAll();
	}

	@Override
	public boolean addProfessionalQualification(TraineeProfessionalQualification traineeProfessionalQualification,
			Trainee trainee) {
		traineeProfessionalQualification.setTrainee(trainee);
		traineeProfessionalQualificationRepository.save(traineeProfessionalQualification);
		return true;
	}

	@Override
	public boolean editProfessionalQualification(Integer id,
			TraineeProfessionalQualification traineeProfessionalQualification, Trainee trainee) {
		if (traineeProfessionalQualificationRepository.getOne(id) != null) {
			traineeProfessionalQualification.setTrainee(trainee);
			traineeProfessionalQualification.setId(id);
			traineeProfessionalQualificationRepository.save(traineeProfessionalQualification);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteProfessionalQualification(Integer id) {
		if (traineeProfessionalQualificationRepository.getOne(id) != null) {
			traineeProfessionalQualificationRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Optional<TraineeProfessionalQualification> getProfessionalQualificationalById(int id) {
		return traineeProfessionalQualificationRepository.findById(id);
	}

	@Override
	public List<TraineeProfessionalQualification> getProfessionalQualificationByTraineeId(int tid) {
		return traineeProfessionalQualificationRepository
				.findProfessionalQualificationByTrainee(traineeRepository.findTraineeById(tid));
	}

}
