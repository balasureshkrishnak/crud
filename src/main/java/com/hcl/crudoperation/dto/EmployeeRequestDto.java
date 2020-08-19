package com.hcl.crudoperation.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class EmployeeRequestDto {

	@NotNull(message = "EmployeeName may not be null")
	@NotEmpty(message = "EmployeeName may not be empty")
	private String employeeName;
	
	@NotNull(message = "Username may not be null")
	@NotEmpty(message = "Username may not be empty")
	private String userName;

	@NotNull(message = "Password may not be null")
	@NotEmpty(message = "Password may not be empty")
	private String password;

	@NotNull(message = "Email may not be null")
	@NotEmpty(message = "Email may not be empty")
	private String emailId;

	private String location;

	private String phoneNumber;

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
