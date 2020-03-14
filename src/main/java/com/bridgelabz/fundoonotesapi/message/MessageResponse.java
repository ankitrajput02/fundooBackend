package com.bridgelabz.fundoonotesapi.message;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;
@Component
public class MessageResponse {
	public SimpleMailMessage verifyMail(String receiverMail,String receiverName,String token) {
		SimpleMailMessage mailMessage=new SimpleMailMessage();
		mailMessage.setTo(receiverMail);
		mailMessage.setFrom("forgotbridge70@gmail.com");
		mailMessage.setSubject("Complete Verification");
		mailMessage.setText("Link"+"http://localhost:8080/userapi/validation/"+token);
		return mailMessage;
		
	}

}
