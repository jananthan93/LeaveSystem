package com.sgic.hrm.trainee.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.hrm.commons.entity.trainee.Trainee;
import com.sgic.hrm.commons.entity.trainee.TraineeWorkExperience;
import com.sgic.hrm.commons.repository.trainee.TraineeRepository;
import com.sgic.hrm.commons.repository.trainee.TraineeWorkExperienceRepository;
import com.sgic.hrm.trainee.service.TraineeWorkExperienceService;

@Service
public class TraineeWorkExperienceServiceImpl implements TraineeWorkExperienceService {
	@Autowired
	private TraineeWorkExperienceRepository experienceRepository;
	@Autowired
	private TraineeRepository taineeRepository;

	@Override
	public boolean addWorkExperience(TraineeWorkExperience traineeWorkExperience, Trainee trainee) {
		traineeWorkExperience.setTrainee(trainee);
		experienceRepository.save(traineeWorkExperience);

		return true;
	}

	@Override
	public List<TraineeWorkExperience> getAllWorkExperience() {
		return experienceRepository.findAll();
	}

	@Override
	public boolean editWorkExperience(TraineeWorkExperience traineeWorkExperience, Trainee trainee, Integer id) {
		boolean editworkex = false;
		if (experienceRepository.getOne(id) != null) {
			traineeWorkExperience.setId(id);
			traineeWorkExperience.setTrainee(trainee);
			experienceRepository.save(traineeWorkExperience);
			editworkex = true;
		}
		return editworkex;
	}

	@Override
	public boolean deleteWorkExperience(Integer id) {
		TraineeWorkExperience traineeWorkExperience = experienceRepository.getOne(id);
		if (traineeWorkExperience.getId() == id) {
			experienceRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public TraineeWorkExperience getWorkExperienceById(int id) {
		return null;
	}

	@Override
	public List<TraineeWorkExperience> getWorkExperienceByTraineeId(Integer uid) {
		return experienceRepository.findWorkExperienceByTrainee(taineeRepository.findTraineeById(uid));
	}

}
