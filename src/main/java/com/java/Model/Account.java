package com.java.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Account")
public class Account {

	@Id
	private String email;
	private String name;
	private String mobile;

	private String role;
	private String password;
	private String address;
	private String otp;
	private boolean validate;

	public Account(String email, String name, String mobile, String role, String password, String address, String otp,
			boolean validate) {
		super();
		this.email = email;
		this.name = name;
		this.mobile = mobile;
		this.role = role;
		this.password = password;
		this.address = address;
		this.otp = otp;
		this.validate = validate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public boolean isValidate() {
		return validate;
	}

	public void setValidate(boolean validate) {
		this.validate = validate;
	}

	@Override
	public String toString() {
		return "Account [email=" + email + ", name=" + name + ", mobile=" + mobile + ", role=" + role + ", password="
				+ password + ", address=" + address + "]";
	}

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

}
