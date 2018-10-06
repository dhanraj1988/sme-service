package com.sme.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sme.controller.AccountDetailsInfo;
import com.sme.controller.BankDetailsInfo;
import com.sme.controller.CurrencyDetailsInfo;

@Entity
@Table(name = "supplier_details")
public class SupplierDetails implements Serializable { 
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="supplier_id")
    private long supplierId;
	@Column(name="name")
	String supplierName;
	@Column(name="payment_mode")
	String paymentmode;
	@Column(name="postal_code")
	int postalcode;
	@Column(name="town")
	String town;
	@Column(name="email")
	String email;
	@Column(name="phonenumber")
	String phonenumber;
	
	
	
/*	@Column(name = "row_cre_timestamp")
	private Timestamp row_cre_timestamp;
	
	@Column(name = "password")
	private Timestamp row_updt_timestamp;
	
	@Column(name = "created_by")
	private String created_by;*/
	
	@OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL)
	/*@OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="acc_id")	*/
	List<AccountDetails> accountdetails;
	
	//@OneToMany(mappedBy = "SupplierDetails", cascade = CascadeType.ALL)
	/*@OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="bank_id")*/
	@OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL)
	List<BankDetails> bankdetails;
	
	//@OneToMany(mappedBy = "SupplierDetails", cascade = CascadeType.ALL)
	/*@OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="bank_id")*/
	@OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL)
	List<CurrencyDetails> currencydetails;

	public long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}

	public String getPaymentmode() {
		return paymentmode;
	}

	public void setPaymentmode(String paymentmode) {
		this.paymentmode = paymentmode;
	}

	public int getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(int postalcode) {
		this.postalcode = postalcode;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	/*public Timestamp getRow_cre_timestamp() {
		return row_cre_timestamp;
	}

	public void setRow_cre_timestamp(Timestamp row_cre_timestamp) {
		this.row_cre_timestamp = row_cre_timestamp;
	}

	public Timestamp getRow_updt_timestamp() {
		return row_updt_timestamp;
	}*/

	/*public void setRow_updt_timestamp(Timestamp row_updt_timestamp) {
		this.row_updt_timestamp = row_updt_timestamp;
	}

	public String getCreated_by() {
		return created_by;
	}*/

/*	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
*/
	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public List<AccountDetails> getAccountdetails() {
		return accountdetails;
	}

	public void setAccountdetails(ArrayList<AccountDetails> accountdetails) {
		this.accountdetails = accountdetails;
	}

	public List<BankDetails> getBankdetails() {
		return bankdetails;
	}

	public void setBankdetails(List<BankDetails> bankdetails) {
		this.bankdetails = bankdetails;
	}

	public List<CurrencyDetails> getCurrencydetails() {
		return currencydetails;
	}

	public void setCurrencydetails(List<CurrencyDetails> currencydetails) {
		this.currencydetails = currencydetails;
	}

	

	
}
