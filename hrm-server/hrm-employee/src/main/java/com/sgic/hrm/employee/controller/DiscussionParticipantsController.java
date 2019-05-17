package com.sgic.hrm.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.hrm.commons.dto.DiscussionParticipantsData;
import com.sgic.hrm.commons.dto.mapper.DiscussionParticipantsDataToDiscussionParticipants;
import com.sgic.hrm.commons.entity.mapper.DiscussionParticipantsToDiscussionParticipantsData;
import com.sgic.hrm.employee.service.DiscussionParticipantsService;

@RestController
public class DiscussionParticipantsController {
	@Autowired
	DiscussionParticipantsService discussionParticipantsService;

	@GetMapping("/discussionParticipants/{id}")
	public ResponseEntity<DiscussionParticipantsData> getById(@PathVariable(name = "id") Integer id) {
		return new ResponseEntity<>(DiscussionParticipantsToDiscussionParticipantsData
				.mapToDiscussionPaticipantsData(discussionParticipantsService.getById(id)), HttpStatus.OK);
	}

	@GetMapping("/discussionParticipants")
	public ResponseEntity<List<DiscussionParticipantsData>> getAllDiscussionParticipants() {

		return new ResponseEntity<>(DiscussionParticipantsToDiscussionParticipantsData
				.mapToDiscussionParticipantsDataList(discussionParticipantsService.getAllDiscussionParticipants()),
				HttpStatus.OK);
	}

	@PostMapping("/discussionParticipants")
	public ResponseEntity<String> addDiscussionParticipants(
			@RequestBody DiscussionParticipantsData discussionParticipantsData) {

		if (discussionParticipantsService.addDiscussionParticipants(DiscussionParticipantsDataToDiscussionParticipants
				.mapToDiscussionPaticipants(discussionParticipantsData))) {
			return new ResponseEntity<>("DiscussionParticipants Create Succesfully ", HttpStatus.OK);
		}
		return new ResponseEntity<>("DiscussionParticipants Create Failed ", HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/discussionParticipants/{id}")
	public ResponseEntity<String> editDiscussionParticipants(@PathVariable(name = "id") Integer id,
			@RequestBody DiscussionParticipantsData discussionParticipantsData) {
		if (discussionParticipantsService.editDiscussionParticipants(DiscussionParticipantsDataToDiscussionParticipants
				.mapToDiscussionPaticipants(discussionParticipantsData), id)) {
			return new ResponseEntity<>("DiscussionParticipants Update Succesfully ", HttpStatus.OK);
		}
		return new ResponseEntity<>("DiscussionParticipants Update Failed ", HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/discussionParticipants/{id}")
	public ResponseEntity<String> deleteDiscussionParticipants(@PathVariable(name = "id") Integer id) {
		if (discussionParticipantsService.deleteDiscussionParticipants(id)) {
			return new ResponseEntity<>("DiscussionParticipants Delete Succesfully ", HttpStatus.OK);
		}
		return new ResponseEntity<>("DiscussionParticipants Delete Failed ", HttpStatus.BAD_REQUEST);

	}
}
