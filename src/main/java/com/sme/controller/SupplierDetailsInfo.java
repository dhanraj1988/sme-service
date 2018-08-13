package com.sme.controller;

import java.util.List;

public class SupplierDetailsInfo {
	String suppliername;
	String paymentmode;
	int postalcode;
	String town;
	String email;
	String phonenumber;
	List<AccountDetailsInfo> accountdetailslist;
	//List<BankDetailsInfo> bankdetails;
	BankDetailsInfo bankdetails;
	CurrencyDetailsInfo currencydetails;
	//List<CurrencyDetailsInfo> currencydetails;

	public String getSuppliername() {
		return suppliername;
	}

	public void setSuppliername(String suppliername) {
		this.suppliername = suppliername;
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

	public List<AccountDetailsInfo> getAccountdetails() {
		return accountdetailslist;
	}

	public void setAccountdetails(List<AccountDetailsInfo> accountdetails) {
		this.accountdetailslist = accountdetails;
	}

	/*public List<AccountDetailsInfo> getAccountdetailslist() {
		return accountdetailslist;
	}

	public void setAccountdetailslist(List<AccountDetailsInfo> accountdetailslist) {
		this.accountdetailslist = accountdetailslist;
	}*/

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

	/*public List<BankDetailsInfo> getBankdetails() {
		return bankdetails;
	}

	public void setBankdetails(List<BankDetailsInfo> bankdetails) {
		this.bankdetails = bankdetails;
	}

	public List<CurrencyDetailsInfo> getCurrencydetails() {
		return currencydetails;
	}

	public void setCurrencydetails(List<CurrencyDetailsInfo> currencydetails) {
		this.currencydetails = currencydetails;
	}*/

}
