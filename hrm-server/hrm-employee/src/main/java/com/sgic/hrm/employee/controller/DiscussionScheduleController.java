package com.sgic.hrm.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.hrm.commons.dto.DiscussionScheduleData;
import com.sgic.hrm.commons.dto.mapper.DiscussionParticipantsDataToDiscussionParticipants;
import com.sgic.hrm.commons.dto.mapper.DiscussionScheduleDataToDiscussionSchedule;
import com.sgic.hrm.commons.entity.mapper.DiscussionScheduleToDiscussionScheduleData;
import com.sgic.hrm.employee.service.DiscussionScheduleService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class DiscussionScheduleController {
	@Autowired
	DiscussionScheduleService discussionScheduleService;

	@GetMapping("/discussionSchedule/{id}")
	public ResponseEntity<DiscussionScheduleData> getById(@PathVariable(name = "id") Integer id) {
		return new ResponseEntity<>(DiscussionScheduleToDiscussionScheduleData
				.mapToDiscussionScheduleData(discussionScheduleService.getById(id)), HttpStatus.OK);
	}

	@GetMapping("/discussionSchedule")
	public ResponseEntity<List<DiscussionScheduleData>> getAllDiscussionSchedule() {

		return new ResponseEntity<>(DiscussionScheduleToDiscussionScheduleData
				.mapToDiscussionScheduleDataList(discussionScheduleService.getAllDiscussionSchedule()), HttpStatus.OK);
	}

	@PostMapping("/discussionSchedule")
	public ResponseEntity<String> addDiscussionSchedule(@RequestBody DiscussionScheduleData discussionScheduleData) {

		if (discussionScheduleService.addDiscussionSchedule(
				DiscussionScheduleDataToDiscussionSchedule.mapToDiscussionSchedule(discussionScheduleData),
				DiscussionParticipantsDataToDiscussionParticipants
						.mapToDiscussionParticipantsList(discussionScheduleData))) {
			return new ResponseEntity<>("TerminationRequest Create Succesfully ", HttpStatus.OK);
		}
		return new ResponseEntity<>("TerminationRequest Create Failed ", HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/discussionSchedule/{id}")
	public ResponseEntity<String> editDiscussionSchedule(@PathVariable(name = "id") Integer id,
			@RequestBody DiscussionScheduleData discussionScheduleData) {
		if (discussionScheduleService.editDiscussionSchedule(
				DiscussionScheduleDataToDiscussionSchedule.mapToDiscussionSchedule(discussionScheduleData), id)) {
			return new ResponseEntity<>("TerminationRequest Update Succesfully ", HttpStatus.OK);
		}
		return new ResponseEntity<>("TerminationRequest Update Failed ", HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/discussionSchedule/{id}")
	public ResponseEntity<String> deleteDiscussionSchedule(@PathVariable(name = "id") Integer id) {
		if (discussionScheduleService.deleteDiscussionSchedule(id)) {
			return new ResponseEntity<>("TerminationRequest Delete Succesfully ", HttpStatus.OK);
		}
		return new ResponseEntity<>("TerminationRequest Delete Failed ", HttpStatus.BAD_REQUEST);

	}

}
