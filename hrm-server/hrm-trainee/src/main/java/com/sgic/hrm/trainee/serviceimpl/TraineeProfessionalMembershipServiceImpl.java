package com.sgic.hrm.trainee.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.trainee.TraineeProfessionalMembership;
import com.sgic.hrm.commons.entity.trainee.Trainee;
import com.sgic.hrm.commons.repository.trainee.TraineeProfessionalMembershipRepository;
import com.sgic.hrm.commons.repository.trainee.TraineeRepository;
import com.sgic.hrm.trainee.service.TraineeProfessionalMembershipService;

@Service
public class TraineeProfessionalMembershipServiceImpl implements TraineeProfessionalMembershipService {

	@Autowired
	private TraineeProfessionalMembershipRepository traineeProfessionalMembershipRepository;
	@Autowired
	private TraineeRepository traineeRepository;

	@Override
	public List<TraineeProfessionalMembership> getAllProfessionalMembership() {
		return traineeProfessionalMembershipRepository.findAll();
	}

	@Override
	public boolean addProfessionalMembership(TraineeProfessionalMembership traineeProfessionalMembership,
			Trainee trainee) {
		traineeProfessionalMembership.setTrainee(trainee);
		traineeProfessionalMembershipRepository.save(traineeProfessionalMembership);
		return true;
	}

	@Override
	public boolean editProfessionalMembership(TraineeProfessionalMembership traineeProfessionalMembership,
			Trainee trainee, Integer id) {
		if (traineeProfessionalMembershipRepository.getOne(id) != null) {
			traineeProfessionalMembership.setTrainee(trainee);
			traineeProfessionalMembership.setId(id);
			traineeProfessionalMembershipRepository.save(traineeProfessionalMembership);
			return true;

		}
		return false;
	}

	@Override
	public boolean deleteProfessionalMembership(Integer id) {
		if (traineeProfessionalMembershipRepository.getOne(id) != null) {
			traineeProfessionalMembershipRepository.deleteById(id);
			return true;

		}
		return false;
	}

	@Override
	public Optional<TraineeProfessionalMembership> getProfessionalMembershipById(Integer id) {
		return traineeProfessionalMembershipRepository.findById(id);
	}

	@Override
	public List<TraineeProfessionalMembership> getProfessionalMembershipByTraineeId(Integer tid) {
		return traineeProfessionalMembershipRepository
				.findProfessionalMembershipByTrainee(traineeRepository.findTraineeById(tid));
	}

}
