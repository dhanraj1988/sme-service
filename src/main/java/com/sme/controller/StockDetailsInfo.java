package com.sme.controller;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "stock_store_details")
public class StockDetailsInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "stock_id")
	private long stockid;
	
	@Column(name = "stock_keeping_unit")
	String stockkeepingunit;
	
	@Column(name = "stock_name")
	String stockname;
	
	@Column(name = "stock_type")
	String stocktype;
	
	@Column(name = "bar_code")
	String barcode;
	
		
	@Column(name = "unit_of_measure")
	String unitofmeasure;
	
	@Column(name = "brand")
	String brand;
	
	@Column(name = "serial_number")
	String serialnumber;
	
	@Column(name = "reorder_level")
	int reorderlevel;
	
	@Column(name = "unit_cost")
	String unitcost;
	
	@Column(name = "description")
	String description;
	
	@Column(name = "tax1")
	int tax1;
	
	@Column(name = "tax2")
	int tax2;
	
	@Column(name = "tax3")
	int tax3;
	
	@OneToMany
	@JoinColumn(name = "stock_ctg_id", nullable = false)
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

	public String getStockkeepingunit() {
		return stockkeepingunit;
	}

	public void setStockkeepingunit(String stockkeepingunit) {
		this.stockkeepingunit = stockkeepingunit;
	}

	public String getStockname() {
		return stockname;
	}

	public void setStockname(String stockname) {
		this.stockname = stockname;
	}

	public String getStocktype() {
		return stocktype;
	}

	public void setStocktype(String stocktype) {
		this.stocktype = stocktype;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getUnitofmeasure() {
		return unitofmeasure;
	}

	public void setUnitofmeasure(String unitofmeasure) {
		this.unitofmeasure = unitofmeasure;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSerialnumber() {
		return serialnumber;
	}

	public void setSerialnumber(String serialnumber) {
		this.serialnumber = serialnumber;
	}

	public int getReorderlevel() {
		return reorderlevel;
	}

	public void setReorderlevel(int reorderlevel) {
		this.reorderlevel = reorderlevel;
	}

	public String getUnitcost() {
		return unitcost;
	}

	public void setUnitcost(String unitcost) {
		this.unitcost = unitcost;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTax1() {
		return tax1;
	}

	public void setTax1(int tax1) {
		this.tax1 = tax1;
	}

	public int getTax2() {
		return tax2;
	}

	public void setTax2(int tax2) {
		this.tax2 = tax2;
	}

	public int getTax3() {
		return tax3;
	}

	public void setTax3(int tax3) {
		this.tax3 = tax3;
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
