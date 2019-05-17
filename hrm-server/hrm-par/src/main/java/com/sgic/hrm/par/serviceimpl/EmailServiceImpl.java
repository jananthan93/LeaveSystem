package com.sgic.hrm.par.serviceimpl;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.dto.email.EmailDto;
import com.sgic.hrm.par.service.EmailService;
@Service
public class EmailServiceImpl implements EmailService {
	@Autowired
	private JavaMailSender emailSender;
	@Override
	public String sendSimpleMessage(EmailDto emailDto) throws MessagingException {
		SimpleMailMessage message = new SimpleMailMessage();
		try {
			message.setSubject(emailDto.getSubject());
			message.setText(emailDto.getContent());
			message.setTo(emailDto.getTo());
			message.setFrom(emailDto.getFrom());
		} catch (Exception e) {
			e.printStackTrace();
            return "Error while sending mail ..";
		}
		emailSender.send(message);
		return "email sent successfully";
	}

}
