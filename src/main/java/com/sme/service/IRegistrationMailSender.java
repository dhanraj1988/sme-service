package com.sme.service;

public interface IRegistrationMailSender {

	String sendMail(String email,String userName,String password);
}
