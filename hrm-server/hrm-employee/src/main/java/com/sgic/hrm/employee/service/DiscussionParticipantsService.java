package com.sgic.hrm.employee.service;

import java.util.List;

import com.sgic.hrm.commons.entity.DiscussionParticipants;

public interface DiscussionParticipantsService {
	 boolean addDiscussionParticipants(DiscussionParticipants discussionParticipants);

	  List<DiscussionParticipants> getAllDiscussionParticipants();

	  boolean editDiscussionParticipants(DiscussionParticipants discussionParticipants, Integer id);

	  boolean deleteDiscussionParticipants(Integer id);

	  DiscussionParticipants getById(Integer id);

}
