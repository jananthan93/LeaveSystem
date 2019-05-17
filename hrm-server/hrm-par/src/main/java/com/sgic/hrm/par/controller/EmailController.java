package com.sgic.hrm.par.controller;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sgic.hrm.commons.dto.email.EmailDto;
import com.sgic.hrm.par.service.EmailService;

public class EmailController {

	private static Logger log = LoggerFactory.getLogger(EmailController.class);
	@Autowired
	private EmailService emailService;

	@PostMapping("/sendMail")
	public String sendEmail(@RequestBody EmailDto emailDto) throws MessagingException {
		try {
			log.info("Spring Mail - Sending Simple Email with JavaMailSender Example");
			   //emailDto.setFrom("thirupparan1994@gmail.com");
			   emailDto.setTo("thirupparan1994@gmail.com");
			   emailDto.setSubject("confirmation par score");
			   emailDto.setContent("Dear thirupparan;");
			   emailDto.setContent("please choose right prefernce for your meal.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Error while sending mail ..";
		}
		return emailService.sendSimpleMessage(emailDto);
	}
}
