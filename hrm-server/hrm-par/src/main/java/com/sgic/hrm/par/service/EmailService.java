package com.sgic.hrm.par.service;

import javax.mail.MessagingException;

import com.sgic.hrm.commons.dto.email.EmailDto;

public interface EmailService {
	public String sendSimpleMessage(EmailDto emailDto) throws MessagingException;
		
	

}
