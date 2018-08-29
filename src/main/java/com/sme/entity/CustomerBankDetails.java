package com.sme.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "customer_bank_details")
public class CustomerBankDetails implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long bank_id;
	@Column(name="name")
	String name;
	@Column(name="code")
	String code;
	@Column(name="branch_town")
	String branchtown;
	@Column(name="building")
	String building;
	@Column(name="postal_name")
	String postalname;
	@Column(name="postal_code")
	String postalcode;
	@Column(name="street")
	String street;
	@Column(name="country_code")
	String countrycode;
	@Column(name="country_name")
	String countryname;
	
	@ManyToOne
	 @JoinColumn(name="customer_id", nullable = false)
	 private CustomerDetails customer;
	
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
	public String getBranchtown() {
		return branchtown;
	}
	public void setBranchtown(String branchtown) {
		this.branchtown = branchtown;
	}
	public String getBuilding() {
		return building;
	}
	public void setBuilding(String building) {
		this.building = building;
	}
	public String getPostalname() {
		return postalname;
	}
	public void setPostalname(String postalname) {
		this.postalname = postalname;
	}
	public String getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCountrycode() {
		return countrycode;
	}
	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}
	public String getCountryname() {
		return countryname;
	}
	public void setCountryname(String countryname) {
		this.countryname = countryname;
	}
	public long getBank_id() {
		return bank_id;
	}
	public void setBank_id(long bank_id) {
		this.bank_id = bank_id;
	}
	public CustomerDetails getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerDetails customer) {
		this.customer = customer;
	}
}
