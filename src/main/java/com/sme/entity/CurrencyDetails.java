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
@Table(name = "currency_details")
public class CurrencyDetails implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long currency_id;
	@Column(name="name")
	String name;
	@Column(name="code")
	String code;
	@Column(name="description")
	String description;
	@Column(name="rounding_symbol")
	String roundingsymbol;
	
	@ManyToOne
	 @JoinColumn(name="supplier_id", nullable = false)
	 private SupplierDetails supplier;
	
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
	public long getCurrency_id() {
		return currency_id;
	}
	public void setCurrency_id(long currency_id) {
		this.currency_id = currency_id;
	}
	public SupplierDetails getSupplier() {
		return supplier;
	}
	public void setSupplier(SupplierDetails supplier) {
		this.supplier = supplier;
	}
}
