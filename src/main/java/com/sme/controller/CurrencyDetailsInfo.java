package com.sme.controller;

public class CurrencyDetailsInfo {
	private long id;
	String name;
	String code;
	String description;
	String roundingsymbol;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRoundingsymbol() {
		return roundingsymbol;
	}

	public void setRoundingsymbol(String roundingsymbol) {
		this.roundingsymbol = roundingsymbol;
	}

	
}
