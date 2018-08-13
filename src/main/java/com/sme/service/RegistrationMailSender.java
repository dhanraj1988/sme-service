package com.sme.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class RegistrationMailSender implements IRegistrationMailSender{

	@Autowired
    private JavaMailSender sender;
	
	
	public String sendMail(String email,String userName,String password) {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        try {
        	String text = "You are Succesfully registered in the SME System, Please use the below credentials to login \n"
        				+"Username : "+userName+"\n"
        				+"Password : "+password;
            helper.setTo(email);
            helper.setText(text);
            helper.setSubject("SME Registration Succesful");
        } catch (MessagingException e) {
            e.printStackTrace();
            return "Error while sending mail ..";
        }
        sender.send(message);
        return "Mail Sent Success!";
    }
}
