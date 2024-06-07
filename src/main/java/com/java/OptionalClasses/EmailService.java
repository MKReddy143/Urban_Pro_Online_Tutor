package com.java.OptionalClasses;

import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class EmailService {

	private final JavaMailSender javamailsender;

	public EmailService(JavaMailSender javamailsender) {
		super();
		this.javamailsender = javamailsender;
	}

	public void sendEmail(String email, String otp) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("abc@gmail.com");
		message.setTo(email);
		message.setSubject("Urbon Pro Login Otp");
		message.setText("Your urbo pro login otp please validate it " + otp);
		javamailsender.send(message);
	}
}
