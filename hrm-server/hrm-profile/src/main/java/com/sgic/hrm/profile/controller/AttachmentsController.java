package com.sgic.hrm.profile.controller;

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

import com.sgic.hrm.commons.dto.AttachmentData;
import com.sgic.hrm.commons.dto.mapper.AttachmentDataToAttachment;
import com.sgic.hrm.commons.entity.mapper.AttachmentsToAttachmentsData;
import com.sgic.hrm.profile.service.AttachmentsService;

@RestController
public class AttachmentsController {
	@Autowired
	AttachmentsService attachmentsService;

	@GetMapping("/attachment/{id}")
	public ResponseEntity<AttachmentData> getById(@PathVariable(name = "id") Integer id) {
		return new ResponseEntity<>(AttachmentsToAttachmentsData.mapToAttachmentData(attachmentsService.getById(id)),
				HttpStatus.OK);
	}

	@GetMapping("/attachment")
	public ResponseEntity<List<AttachmentData>> getAllAttachments() {

		return new ResponseEntity<>(
				AttachmentsToAttachmentsData.mapToAttachmentDataList(attachmentsService.getAllAttachments()),
				HttpStatus.OK);
	}

	@PostMapping("/attachment")
	public ResponseEntity<String> addAttachments(@RequestBody AttachmentData attachmentData) {

		if (attachmentsService.addAttachments(AttachmentDataToAttachment.mapToAttachments(attachmentData))) {
			return new ResponseEntity<>("Attachment Create Succesfully ", HttpStatus.OK);
		}
		return new ResponseEntity<>("Attachment Create Failed ", HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/attachment/{id}")
	public ResponseEntity<String> editAttachments(@PathVariable(name = "id") Integer id,
			@RequestBody AttachmentData attachmentData) {
		if (attachmentsService.editAttachments(AttachmentDataToAttachment.mapToAttachments(attachmentData), id)) {
			return new ResponseEntity<>("Attachment Update Succesfully ", HttpStatus.OK);
		}
		return new ResponseEntity<>("Attachment Update Failed ", HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping
	public ResponseEntity<String> deleteAttachments(@PathVariable(name = "id") Integer id) {
		if (attachmentsService.deleteAttachments(id)) {
			return new ResponseEntity<>("Attachment Delete Succesfully ", HttpStatus.OK);
		}
		return new ResponseEntity<>("Attachment Delete Failed ", HttpStatus.BAD_REQUEST);

	}

}
