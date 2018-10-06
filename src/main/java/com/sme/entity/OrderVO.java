package com.sme.entity;

import java.io.Serializable;
import java.sql.Date;
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

import com.sme.controller.StoreDetailsInfo;

@Entity
@Table(name = "order_details")
public class OrderVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long order_id;
	
	@ManyToOne
	@JoinColumn(name="store_id", nullable = false)
	StoreDetailsInfo store;
	
	@Column(name="order_date")
	Date order_date;
	
	@Column(name="isdeleted")
	Boolean isDeleted;
	
	@Column(name="row_cre_dt")
	Timestamp rowcredt;
	
	@Column(name="row_upd_dt")
	Timestamp rowupddt;

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

	public long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}

	public StoreDetailsInfo getStore() {
		return store;
	}

	public void setStore(StoreDetailsInfo store) {
		this.store = store;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

}
