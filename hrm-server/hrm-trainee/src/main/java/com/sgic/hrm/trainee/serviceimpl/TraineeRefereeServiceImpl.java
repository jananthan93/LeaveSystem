package com.sgic.hrm.trainee.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.trainee.TraineeReferee;
import com.sgic.hrm.commons.entity.trainee.Trainee;
import com.sgic.hrm.commons.repository.trainee.TraineeRefereeRepository;
import com.sgic.hrm.commons.repository.trainee.TraineeRepository;
import com.sgic.hrm.trainee.service.TraineeRefereeService;

@Service
public class TraineeRefereeServiceImpl implements TraineeRefereeService {
	@Autowired
	private TraineeRefereeRepository traineeRefereeRepository;
	@Autowired
	private TraineeRepository traineeRepository;

	@Override
	public boolean addReferee(TraineeReferee traineeReferee, Trainee trainee) {
		traineeReferee.setTrainee(trainee);
		traineeRefereeRepository.save(traineeReferee);
		return true;
	}

	@Override
	public List<TraineeReferee> getAllReferee() {
		return traineeRefereeRepository.findAll();
	}

	@Override
	public boolean editReferee(TraineeReferee traineeReferee, int id, Trainee trainee) {
		if (traineeRefereeRepository.getOne(id) != null) {
			traineeReferee.setId(id);
			traineeReferee.setTrainee(trainee);
			traineeRefereeRepository.save(traineeReferee);
			return true;
		}
		return false;
	}

	@Override
	public Optional<TraineeReferee> getRefereeById(int id) {
		return traineeRefereeRepository.findById(id);
	}

	@Override
	public boolean deleteReferee(int id) {
		if (traineeRefereeRepository.getOne(id) != null) {
			traineeRefereeRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public List<TraineeReferee> getRefereeByTraineeId(Integer id) {
		return traineeRefereeRepository.findRefereeByTrainee(traineeRepository.findTraineeById(id));
	}

}
