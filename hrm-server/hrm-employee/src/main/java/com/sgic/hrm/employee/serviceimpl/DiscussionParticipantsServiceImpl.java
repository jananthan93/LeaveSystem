package com.sgic.hrm.employee.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.DiscussionParticipants;
import com.sgic.hrm.commons.repository.DiscussionParticipantsRepository;
import com.sgic.hrm.employee.service.DiscussionParticipantsService;

@Service
public class DiscussionParticipantsServiceImpl implements DiscussionParticipantsService{
	@Autowired
	DiscussionParticipantsRepository discussionParticipantsRepository;

	@Override
	public boolean addDiscussionParticipants(DiscussionParticipants discussionParticipants) {
		discussionParticipantsRepository.save(discussionParticipants);
		return true;
	}

	@Override
	public List<DiscussionParticipants> getAllDiscussionParticipants() {
		
		return discussionParticipantsRepository.findAll();
	}

	@Override
	public boolean editDiscussionParticipants(DiscussionParticipants discussionParticipants, Integer id) {
		if(discussionParticipantsRepository.getOne(id)!=null) {
			discussionParticipants.setId(id);
			discussionParticipantsRepository.save(discussionParticipants);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteDiscussionParticipants(Integer id) {
		discussionParticipantsRepository.deleteById(id);
		return true;
	}

	@Override
	public DiscussionParticipants getById(Integer id) {
		
		return discussionParticipantsRepository.findById(id).orElse(null);
	}

}
