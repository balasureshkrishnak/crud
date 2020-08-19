package com.hcl.crudoperation.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.crudoperation.config.ApplicationConstants;
import com.hcl.crudoperation.dto.EmployeeDto;
import com.hcl.crudoperation.dto.EmployeeRequestDto;
import com.hcl.crudoperation.dto.EmployeeResponseDto;
import com.hcl.crudoperation.dto.ResponseDto;
import com.hcl.crudoperation.entity.Employee;
import com.hcl.crudoperation.exception.EmployeeNotFoundException;
import com.hcl.crudoperation.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	EmployeeRepository employeeRepository;

	public ResponseDto addEmployee(EmployeeRequestDto employeeRequestDto) {
		logger.info("inside add employee method of service: ");
		ResponseDto responseDto = new ResponseDto();
		Employee employee = new Employee();
		BeanUtils.copyProperties(employeeRequestDto, employee);
		employeeRepository.save(employee);
		responseDto.setStatusCode(HttpStatus.CREATED.value());
		responseDto.setStatusMessage(ApplicationConstants.ADD_EMPLOYEE);
		return responseDto;
	}

	public EmployeeResponseDto getAllEmployees() {
		logger.info("getting all employee details: ");
		EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();
		List<Employee> employees = employeeRepository.findAll();
		List<EmployeeDto> employeeDtos = new ArrayList<>();
		for (Employee employee : employees) {
			EmployeeDto employeeDto = new EmployeeDto();
			BeanUtils.copyProperties(employee, employeeDto);
			employeeDtos.add(employeeDto);
		}
		employeeResponseDto.setEmployeeDtoList(employeeDtos);
		employeeResponseDto.setStatusMessage(ApplicationConstants.LIST_OF_EMPLOYEES);
		employeeResponseDto.setStatusCode(HttpStatus.OK.value());

		return employeeResponseDto;
	}

	public EmployeeResponseDto searchEmployees(String employeeName) throws EmployeeNotFoundException {
		logger.info("searching for employees by name or by part of a name: ");
		EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();
		Optional<List<Employee>> employees = employeeRepository.findByEmployeeNameContains(employeeName);
		List<EmployeeDto> employeeDtos = new ArrayList<>();
		if (employees.isPresent()) {
			List<Employee> employeeList = new ArrayList<>();
			employeeList = employees.get();
			for (Employee employee : employeeList) {
				EmployeeDto employeeDto = new EmployeeDto();
				BeanUtils.copyProperties(employee, employeeDto);
				employeeDtos.add(employeeDto);
			}
			employeeResponseDto.setEmployeeDtoList(employeeDtos);
			employeeResponseDto.setStatusMessage(ApplicationConstants.LIST_OF_EMPLOYEES);
			employeeResponseDto.setStatusCode(HttpStatus.OK.value());

			return employeeResponseDto;
		} else {
			throw new EmployeeNotFoundException(ApplicationConstants.NO_EMPLOYEE_FOUND);
		}
	}

	public ResponseDto updateEmployee(Integer employeeId, Employee employee) throws EmployeeNotFoundException {
		logger.info("updating employee based on id and details: ");
		ResponseDto responseDto = new ResponseDto();
		Optional<Employee> employees = employeeRepository.findByEmployeeId(employeeId);
		if (employees.isPresent()) {
			employee.setEmployeeId(employeeId);
			employeeRepository.save(employee);
			responseDto.setStatusMessage(ApplicationConstants.UPDATE_EMPLOYEE);
			responseDto.setStatusCode(HttpStatus.ACCEPTED.value());
			return responseDto;
		} else {
			throw new EmployeeNotFoundException(ApplicationConstants.EMPLOYEE_NOT_FOUND);
		}
	}

	public ResponseDto deleteEmployee(Integer employeeId) throws EmployeeNotFoundException {
		logger.info("deleting an employee based on Id: ");
		ResponseDto responseDto = new ResponseDto();
		Optional<Employee> employees = employeeRepository.findByEmployeeId(employeeId);
		if (employees.isPresent()) {
			employeeRepository.delete(employees.get());
			responseDto.setStatusMessage(ApplicationConstants.DELETE_EMPLOYEE);
			responseDto.setStatusCode(HttpStatus.ACCEPTED.value());
			return responseDto;
		} else {
			throw new EmployeeNotFoundException(ApplicationConstants.EMPLOYEE_NOT_FOUND);
		}
	}

}
