package com.sgic.hrm.employee.service;

import java.util.List;

import com.sgic.hrm.commons.entity.DiscussionParticipants;
import com.sgic.hrm.commons.entity.DiscussionSchedule;

public interface DiscussionScheduleService {
	boolean addDiscussionSchedule(DiscussionSchedule discussionSchedule,
			List<DiscussionParticipants> discussionParticipants);

	List<DiscussionSchedule> getAllDiscussionSchedule();

	boolean editDiscussionSchedule(DiscussionSchedule discussionSchedule, Integer id);

	boolean deleteDiscussionSchedule(Integer id);

	DiscussionSchedule getById(Integer id);

}
