package com.sme.controller;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "stock_category")
public class StockCategoryInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "stock_ctg_id")
	private long stockctgid;

	@Column(name = "stock_category_name")
	String stockcategoryname;

	@Column(name = "ctg_short_name")
	String ctgshortname;
	
	@Column(name="row_cre_dt")
	Timestamp rowcredt;
	
	@Column(name="row_upd_dt")
	Timestamp rowupddt;
	
	@OneToMany(mappedBy = "stockCategoryInfo",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	//@JoinColumn(name = "stock_ctg_id")
	@JsonManagedReference
	List<StockVO> stockVO;

	public List<StockVO> getStockVO() {
		return stockVO;
	}

	public void setStockVO(List<StockVO> stockVO) {
		this.stockVO = stockVO;
	}

	public long getStockctgid() {
		return stockctgid;
	}

	public void setStockctgid(long stockctgid) {
		this.stockctgid = stockctgid;
	}

	public String getStockcategoryname() {
		return stockcategoryname;
	}

	public void setStockcategoryname(String stockcategoryname) {
		this.stockcategoryname = stockcategoryname;
	}

	public String getCtgshortname() {
		return ctgshortname;
	}

	public void setCtgshortname(String ctgshortname) {
		this.ctgshortname = ctgshortname;
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
