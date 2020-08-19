package com.hcl.crudoperation.dto;

import java.util.List;

public class EmployeeResponseDto {

	private Integer statusCode;

	private String statusMessage;

	private List<EmployeeDto> employeeDtoList;

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public List<EmployeeDto> getEmployeeDtoList() {
		return employeeDtoList;
	}

	public void setEmployeeDtoList(List<EmployeeDto> employeeDtoList) {
		this.employeeDtoList = employeeDtoList;
	}

}
