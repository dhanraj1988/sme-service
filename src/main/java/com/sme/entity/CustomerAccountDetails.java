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
@Table(name = "customer_account_details")
public class CustomerAccountDetails implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long acc_id;
	
	@Column(name="name")
	String name;
	@Column(name="number")
	String number;
	@Column(name="code")
	String code;
	@Column(name="start_accounting_period_month")
	String startaccountingperiodmonth;
	
	 @ManyToOne
	 @JoinColumn(name="customer_id", nullable = false)
	 private CustomerDetails customer;
	
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
	public CustomerDetails getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerDetails customer) {
		this.customer = customer;
	}
	
}
