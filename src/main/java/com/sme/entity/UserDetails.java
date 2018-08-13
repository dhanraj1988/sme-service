package com.sme.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_details")
public class UserDetails implements Serializable {
	
	private static final long serialVersionUID = 1L; 
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long usr_id;
	
	@Column(name = "title")
	private String title;
	@Column(name = "Company_name")
	private String companyName;
	@Column(name = "Language")
	private String language;
	@Column(name = "Country")
	private String country;
	@Column(name = "State")
	private String state;
	@Column(name = "postal_code")
	private Integer postalCode;
	@Column(name = "city")
	private String city;
	@Column(name = "street")
	private String street;
	@Column(name = "house_number")
	private String houseNumber;
	@Column(name = "address_line1")
	private String addressLine1;
	@Column(name = "address_line2")
	private String addressLine2;
	@Column(name = "address_line3")
	private String addressLine3;
	@Column(name = "supplier_type")
	private String supplierType;
	@Column(name = "telephone1")
	private Integer telephone1;
	@Column(name = "telephone2")
	private Integer telephone2;
	@Column(name = "fax_no")
	private Integer faxNo;
	@Column(name = "company_email")
	private String companyEmail;
	@Column(name = "company_website")
	private String companyWebsite;
	@Column(name = "password")
	private String password;
	@Column(name = "retype_password")
	private String retypePassword;
	
	@Column(name = "invalid")
	private Boolean invalid;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getSupplierType() {
		return supplierType;
	}

	public void setSupplierType(String supplierType) {
		this.supplierType = supplierType;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRetypePassword() {
		return retypePassword;
	}

	public void setRetypePassword(String retypePassword) {
		this.retypePassword = retypePassword;
	}

	public long getUsr_id() {
		return usr_id;
	}

	public void setUsr_id(long usr_id) {
		this.usr_id = usr_id;
	}

	public Boolean getInvalid() {
		return invalid;
	}

	public void setInvalid(Boolean invalid) {
		this.invalid = invalid;
	}

	public Integer getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressLine3() {
		return addressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	public Integer getTelephone1() {
		return telephone1;
	}

	public void setTelephone1(Integer telephone1) {
		this.telephone1 = telephone1;
	}

	public Integer getTelephone2() {
		return telephone2;
	}

	public void setTelephone2(Integer telephone2) {
		this.telephone2 = telephone2;
	}

	public Integer getFaxNo() {
		return faxNo;
	}

	public void setFaxNo(Integer faxNo) {
		this.faxNo = faxNo;
	}

	public String getCompanyEmail() {
		return companyEmail;
	}

	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}

	public String getCompanyWebsite() {
		return companyWebsite;
	}

	public void setCompanyWebsite(String companyWebsite) {
		this.companyWebsite = companyWebsite;
	}

/*	public Charts(String Title,String CompanyName,String Language,String Country,String State,int PostalCode,String City,String Street,String HouseNumber,String AddressLine1,String AddressLine2,String AddressLine3,String SupplierType,int Telephone1,int Telephone2,int FaxNo,String CompanyEmail,String CompanyWebsite,String Password,String RetypePassword) {
		this.Title= Title;
		this.CompanyName= CompanyName;
		this.Language= Language;
		this.Country= Country;
		this.State= State;
		this.PostalCode= PostalCode;
		this.City= City;
		this.Street= Street;
		this.HouseNumber= HouseNumber;
		this.AddressLine1= AddressLine1;
		this.AddressLine2= AddressLine2;
		this.AddressLine3= AddressLine3;
		this.SupplierType= SupplierType;
		this.Telephone1= Telephone1;
		this.Telephone2= Telephone2;
		this.FaxNo= FaxNo;
		this.CompanyEmail= CompanyEmail;
		this.CompanyWebsite= CompanyWebsite;
		this.Password= Password;
		this.RetypePassword= RetypePassword;
	}
	@Override
	public String toString() {
		return String.format("Charts[Title=%s,CompanyName=%s,Language=%s,Country=%s,State=%s,PostalCode=%d,City=%s,Street=%s,HouseNumber=%s,AddressLine1=%s,AddressLine2=%s,AddressLine3=%s,SupplierType=%s,Telephone1=%d,Telephone2=%d,FaxNo=%d,CompanyEmail=%s,CompanyWebsite=%s,Password=%s,RetypePassword=%s]",id,Title,CompanyName,Language,Country,State,PostalCode,City,Street,HouseNumber,AddressLine1,AddressLine2,AddressLine3,SupplierType,Telephone1,Telephone2,FaxNo,CompanyEmail,CompanyWebsite,Password,RetypePassword);
	}*/
}
