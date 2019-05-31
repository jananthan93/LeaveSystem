package com.sgic.hrm.lms.controller;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.hrm.commons.entity.RejectCarryforwardRequest;
import com.sgic.hrm.lms.service.RejectCarryforwardRequestService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/rejectCarry")
public class RejectCarryForwardRequestController {
	@Autowired
	private RejectCarryforwardRequestService rejectCarryforwardRequestService;
	
	@GetMapping("/reject/{username}")
	public RejectCarryforwardRequest getRejectCarryForwardRequestByUser(@PathVariable String username) {
		//System.out.println(rejectCarryforwardRequestService.getRejectCarryforwardRequestByUser(username));
		return rejectCarryforwardRequestService.getRejectCarryforwardRequestByUser(username);
	}
}
