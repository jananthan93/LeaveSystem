package com.sgic.hrm.employee.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.DiscussionParticipants;
import com.sgic.hrm.commons.entity.DiscussionSchedule;
import com.sgic.hrm.commons.entity.TerminationRequest;
import com.sgic.hrm.commons.repository.DiscussionParticipantsRepository;
import com.sgic.hrm.commons.repository.DiscussionScheduleRepository;
import com.sgic.hrm.commons.repository.TerminationRequestRepository;
import com.sgic.hrm.employee.service.DiscussionScheduleService;

@Service
public class DiscussionScheduleServiceImpl implements DiscussionScheduleService {
	@Autowired
	DiscussionScheduleRepository discussionScheduleRepository;
	@Autowired
	DiscussionParticipantsRepository discussionParticipantsRepository;
	@Autowired
	TerminationRequestRepository terminationRequestRepository;

	@Transactional
	@Override
	public boolean addDiscussionSchedule(DiscussionSchedule discussionSchedule,
			List<DiscussionParticipants> discussionParticipants) {

		discussionScheduleRepository.save(discussionSchedule);
		DiscussionSchedule schedule = discussionScheduleRepository
				.findByTerminationRequest(discussionSchedule.getTerminationRequest());

		for (DiscussionParticipants participant : discussionParticipants) {
			participant.setDiscussionSchedule(schedule);
			discussionParticipantsRepository.save(participant);
		}
		return true;
	}

	@Override
	public List<DiscussionSchedule> getAllDiscussionSchedule() {

		return discussionScheduleRepository.findAll();
	}

	@Override
	public boolean editDiscussionSchedule(DiscussionSchedule discussionSchedule, Integer id) {
		if (discussionScheduleRepository.getOne(id) != null) {
			discussionSchedule.setId(id);
			discussionScheduleRepository.save(discussionSchedule);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteDiscussionSchedule(Integer id) {
		discussionScheduleRepository.deleteById(id);
		return true;
	}

	@Override
	public DiscussionSchedule getById(Integer id) {
		return discussionScheduleRepository.findById(id).orElse(null);

	}

}
