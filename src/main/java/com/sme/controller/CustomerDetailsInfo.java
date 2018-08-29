package com.sme.controller;

import java.util.ArrayList;

public class CustomerDetailsInfo {
	String customername;
	String paymentmode;
	Integer postalcode;
	String town;
	String email;
	String phonenumber;
	ArrayList<AccountDetailsInfo> accountdetailslist;
	//List<BankDetailsInfo> bankdetails;
	BankDetailsInfo bankdetails;
	CurrencyDetailsInfo currencydetails;
	//List<CurrencyDetailsInfo> currencydetails;

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getPaymentmode() {
		return paymentmode;
	}

	public void setPaymentmode(String paymentmode) {
		this.paymentmode = paymentmode;
	}

	public int getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(int postalcode) {
		this.postalcode = postalcode;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public ArrayList<AccountDetailsInfo> getAccountdetailslist() {
		return accountdetailslist;
	}

	public void setAccountdetailslist(ArrayList<AccountDetailsInfo> accountdetailslist) {
		this.accountdetailslist = accountdetailslist;
	}

	public BankDetailsInfo getBankdetails() {
		return bankdetails;
	}

	public void setBankdetails(BankDetailsInfo bankdetails) {
		this.bankdetails = bankdetails;
	}

	public CurrencyDetailsInfo getCurrencydetails() {
		return currencydetails;
	}

	public void setCurrencydetails(CurrencyDetailsInfo currencydetails) {
		this.currencydetails = currencydetails;
	}

	


}
