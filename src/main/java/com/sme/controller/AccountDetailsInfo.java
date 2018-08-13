package com.sme.controller;

public class AccountDetailsInfo {
	long acc_id;
	String name;
	String number;
	String code;
	String startaccountingperiodmonth;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getStartaccountingperiodmonth() {
		return startaccountingperiodmonth;
	}

	public void setStartaccountingperiodmonth(String startaccountingperiodmonth) {
		this.startaccountingperiodmonth = startaccountingperiodmonth;
	}

	public long getAcc_id() {
		return acc_id;
	}

	public void setAcc_id(long acc_id) {
		this.acc_id = acc_id;
	}
}
