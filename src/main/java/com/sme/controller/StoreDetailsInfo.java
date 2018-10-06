package com.sme.controller;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sme.entity.UserDetails;
@Entity
@Table(name = "store_details")
public class StoreDetailsInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "store_id")
	private long storeId;
	
	@Column(name = "store_number")
	String storenumber;
	
	@Column(name = "store_name")
	String storename;
	
	@Column(name = "storelocation")
	int storelocation;
	
	@Column(name = "isdeleted")
	String isdeleted;
	
	@Column(name="row_cre_dt")
	Timestamp rowcredt;
	
	@Column(name="row_upd_dt")
	Timestamp rowupddt;
	
	public String getIsdeleted() {
		return isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	public Timestamp getRowcredt() {
		return rowcredt;
	}

	public void setRowcredt(Timestamp rowcredt) {
		this.rowcredt = rowcredt;
	}

	public Timestamp getRowupddt() {
		return rowupddt;
	}

	public void setRowupddt(Timestamp rowupddt) {
		this.rowupddt = rowupddt;
	}

	public long getStoreId() {
		return storeId;
	}

	public void setStoreId(long storeId) {
		this.storeId = storeId;
	}

	public String getStorenumber() {
		return storenumber;
	}

	public void setStorenumber(String storenumber) {
		this.storenumber = storenumber;
	}

	public String getStorename() {
		return storename;
	}

	public void setStorename(String storename) {
		this.storename = storename;
	}

	public int getStorelocation() {
		return storelocation;
	}

	public void setStorelocation(int storelocation) {
		this.storelocation = storelocation;
	}

}
