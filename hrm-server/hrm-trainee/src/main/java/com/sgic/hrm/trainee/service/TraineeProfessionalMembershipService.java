package com.sgic.hrm.trainee.service;

import java.util.List;
import java.util.Optional;

import com.sgic.hrm.commons.entity.trainee.TraineeProfessionalMembership;
import com.sgic.hrm.commons.entity.trainee.Trainee;

public interface TraineeProfessionalMembershipService {
	List<TraineeProfessionalMembership> getAllProfessionalMembership();

	boolean addProfessionalMembership(TraineeProfessionalMembership traineeProfessionalMembership, Trainee trainee);

	boolean editProfessionalMembership(TraineeProfessionalMembership traineeProfessionalMembership, Trainee trainee,
			Integer id);

	boolean deleteProfessionalMembership(Integer id);

	Optional<TraineeProfessionalMembership> getProfessionalMembershipById(Integer id);

	List<TraineeProfessionalMembership> getProfessionalMembershipByTraineeId(Integer tid);
}
