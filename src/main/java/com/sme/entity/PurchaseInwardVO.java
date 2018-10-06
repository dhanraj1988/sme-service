package com.sme.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class PurchaseInwardVO implements Serializable{

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long purchase_inward_id;
	
	@OneToOne
	@JoinColumn(name="purchase_order_id", nullable = false)
	PurchaseOrderVO purchaseOrder;
	
	@Column(name="grn_number")
	String grnnumber;
	
	@Column(name="delivery_note_number")
	String deliverynotenumber;
	
	@Column(name="delivery_date")
	String deliverydate;
	
	@Column(name="row_cre_dt")
	Timestamp rowcredt;
	
	@Column(name="row_upd_dt")
	Timestamp rowupddt;
	
	
	public long getPurchase_inward_id() {
		return purchase_inward_id;
	}

	public void setPurchase_inward_id(long purchase_inward_id) {
		this.purchase_inward_id = purchase_inward_id;
	}

	public PurchaseOrderVO getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrderVO purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	public String getGrnnumber() {
		return grnnumber;
	}

	public void setGrnnumber(String grnnumber) {
		this.grnnumber = grnnumber;
	}

	public String getDeliverynotenumber() {
		return deliverynotenumber;
	}

	public void setDeliverynotenumber(String deliverynotenumber) {
		this.deliverynotenumber = deliverynotenumber;
	}

	public String getDeliverydate() {
		return deliverydate;
	}

	public void setDeliverydate(String deliverydate) {
		this.deliverydate = deliverydate;
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
