package com.sme.controller;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "stock_metadata")
public class StockVO implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "stock_id")
	private long stockid;
	
	@Column(name = "stock_name")
	String stockname;
	
	@Column(name = "description")
	String description;
	
	@ManyToOne
	@JoinColumn(name = "stock_ctg_id", nullable = false)
	@JsonBackReference
	StockCategoryInfo stockCategoryInfo;

	
	@Column(name="row_cre_dt")
	Timestamp rowcredt;
	
	@Column(name="row_upd_dt")
	Timestamp rowupddt;
	
	public long getStockid() {
		return stockid;
	}

	public void setStockid(long stockid) {
		this.stockid = stockid;
	}

	public String getStockname() {
		return stockname;
	}

	public void setStockname(String stockname) {
		this.stockname = stockname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public StockCategoryInfo getStockCategoryInfo() {
		return stockCategoryInfo;
	}

	public void setStockCategoryInfo(StockCategoryInfo stockCategoryInfo) {
		this.stockCategoryInfo = stockCategoryInfo;
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

	
}
