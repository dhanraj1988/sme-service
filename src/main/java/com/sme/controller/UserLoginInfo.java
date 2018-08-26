package com.sme.controller;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class UserLoginInfo {
	
	@JsonInclude(Include.NON_NULL)
    private String userName;
	@JsonInclude(Include.NON_NULL)
    private String password;
	
	private Boolean valid;
	
	private String logintype;
	
	private ArrayList<TestModel> testarray;
	
	public String getLogintype() {
		return logintype;
	}
	public void setLogintype(String logintype) {
		this.logintype = logintype;
	}
	public ArrayList<TestModel> getTestarray() {
		return testarray;
	}
	public void setTestarray(ArrayList<TestModel> testarray) {
		this.testarray = testarray;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Boolean getValid() {
		return valid;
	}
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
	
	
}