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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "purchase_order_details")
public class PurchaseOrderVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long purchase_order_id;
	
	@ManyToOne
	@JoinColumn(name="supplier_id", nullable = false)
	SupplierDetails supplier;
	
	@OneToOne
	@JoinColumn(name="order_id", nullable = false)
	OrderVO order;
	
	@OneToOne
	@JoinColumn(name="usr_id", nullable = false)
	UserDetails usr_dtls;
	
	@Column(name="order_status")
	String order_status;
	
	@Column(name="delivery_date")
	Date delivery_date;
	
	@Column(name="tax_rate")
	Float tax_rate;
	
	@Column(name="discount")
	Float discount;
	
	@Column(name="order_value")
	Double order_value;
	
	@Column(name="comments")
	String comments;
	
	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
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
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		this.rowupddt = timestamp;
	}

	@Column(name="row_cre_dt")
	Timestamp rowcredt;
	
	@Column(name="row_upd_dt")
	Timestamp rowupddt;
	
	public long getPurchase_order_id() {
		return purchase_order_id;
	}

	public void setPurchase_order_id(long purchase_order_id) {
		this.purchase_order_id = purchase_order_id;
	}

	public SupplierDetails getSupplier() {
		return supplier;
	}

	public void setSupplier(SupplierDetails supplier) {
		this.supplier = supplier;
	}

	public OrderVO getOrder() {
		return order;
	}

	public void setOrder(OrderVO order) {
		this.order = order;
	}

	public Date getDelivery_date() {
		return delivery_date;
	}

	public void setDelivery_date(Date delivery_date) {
		this.delivery_date = delivery_date;
	}

	public Float getTax_rate() {
		return tax_rate;
	}

	public void setTax_rate(Float tax_rate) {
		this.tax_rate = tax_rate;
	}

	public Float getDiscount() {
		return discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

	public Double getOrder_value() {
		return order_value;
	}

	public void setOrder_value(Double order_value) {
		this.order_value = order_value;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public UserDetails getUsr_dtls() {
		return usr_dtls;
	}

	public void setUsr_dtls(UserDetails usr_dtls) {
		this.usr_dtls = usr_dtls;
	}

	
}
