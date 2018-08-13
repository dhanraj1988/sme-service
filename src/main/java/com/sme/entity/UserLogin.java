/*package com.sme.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_details")
public class UserLogin implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "user_name")
	private String companyName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "row_cre_timestamp")
	private Timestamp row_cre_timestamp;
	
	@Column(name = "password")
	private Timestamp row_updt_timestamp;
	
	@Column(name = "created_by")
	private String created_by;
	
	@OneToOne
    @JoinColumn(name="user_id")
	private UserDetails user_details;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getRow_cre_timestamp() {
		return row_cre_timestamp;
	}

	public void setRow_cre_timestamp(Timestamp row_cre_timestamp) {
		this.row_cre_timestamp = row_cre_timestamp;
	}

	public Timestamp getRow_updt_timestamp() {
		return row_updt_timestamp;
	}

	public void setRow_updt_timestamp(Timestamp row_updt_timestamp) {
		this.row_updt_timestamp = row_updt_timestamp;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public UserDetails getUser_details() {
		return user_details;
	}

	public void setUser_details(UserDetails user_details) {
		this.user_details = user_details;
	}
	
}
*/