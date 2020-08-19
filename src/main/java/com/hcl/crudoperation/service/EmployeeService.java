package com.hcl.crudoperation.service;

import com.hcl.crudoperation.dto.EmployeeRequestDto;
import com.hcl.crudoperation.dto.EmployeeResponseDto;
import com.hcl.crudoperation.dto.ResponseDto;
import com.hcl.crudoperation.entity.Employee;
import com.hcl.crudoperation.exception.EmployeeNotFoundException;

public interface EmployeeService {
	
	public ResponseDto addEmployee(EmployeeRequestDto employeeRequestDto);
	
	public EmployeeResponseDto getAllEmployees();
	
	public EmployeeResponseDto searchEmployees(String employeeName) throws EmployeeNotFoundException;
	
	public ResponseDto updateEmployee(Integer id, Employee employee) throws EmployeeNotFoundException;
	
	public ResponseDto deleteEmployee(Integer id) throws EmployeeNotFoundException;

}
