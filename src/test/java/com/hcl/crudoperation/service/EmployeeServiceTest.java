package com.hcl.crudoperation.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.crudoperation.config.ApplicationConstants;
import com.hcl.crudoperation.dto.EmployeeDto;
import com.hcl.crudoperation.dto.EmployeeRequestDto;
import com.hcl.crudoperation.dto.EmployeeResponseDto;
import com.hcl.crudoperation.dto.ResponseDto;
import com.hcl.crudoperation.entity.Employee;
import com.hcl.crudoperation.repository.EmployeeRepository;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.Silent.class)
public class EmployeeServiceTest {
	
	@InjectMocks
	EmployeeServiceImpl employeeServiceImpl;
	
	@Mock
	EmployeeRepository employeeRepository;
	
	@Test
	public void testForAddEmployee() {
		ResponseDto responseDto = new ResponseDto();
		EmployeeRequestDto employeeRequestDto = new EmployeeRequestDto();
		employeeRequestDto.setEmployeeName("bala");
		employeeRequestDto.setLocation("bangalore");
		employeeRequestDto.setPassword("bala");
		employeeRequestDto.setPhoneNumber("9705441499");
		employeeRequestDto.setUserName("bala");
		employeeRequestDto.setEmailId("bala.k@gmail.com");
		Employee employee = new Employee();
		employee.setEmployeeId(1);
		employee.setEmployeeName("bala");
		employee.setLocation("bangalore");
		employee.setPassword("bala");
		employee.setPhoneNumber("9705441499");
		employee.setUserName("bala");
		employee.setEmailId("bala.k@gmail.com");
		Mockito.when(employeeRepository.save(employee)).thenReturn(employee);
		responseDto = employeeServiceImpl.addEmployee(employeeRequestDto);
		Assert.assertNotNull(responseDto);
		Assert.assertEquals(ApplicationConstants.ADD_EMPLOYEE, responseDto.getStatusMessage());
	}
	
	@Test
	public void testForGetAllEmployees() {
		EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();
		Employee employee = new Employee();
		Employee employee1 = new Employee();
		employee.setEmployeeId(1);
		employee.setEmployeeName("bala");
		employee.setLocation("bangalore");
		employee.setPassword("bala");
		employee.setPhoneNumber("9705441499");
		employee.setUserName("bala");
		employee.setEmailId("bala.k@gmail.com");
		employee1.setEmployeeId(2);
		employee1.setEmployeeName("suresh");
		employee1.setLocation("ecity");
		employee1.setPassword("suresh");
		employee1.setPhoneNumber("9705441400");
		employee1.setUserName("suresh");
		employee1.setEmailId("suresh.k@gmail.com");
		
		List<Employee> employeeList = new ArrayList<>();
		
		employeeList.add(employee);
		employeeList.add(employee1);
		
		List<EmployeeDto> employeeDtoList = new ArrayList<>();
		EmployeeDto employeeDto = new EmployeeDto();
		EmployeeDto employeeDto1 = new EmployeeDto();
		employeeDto.setEmployeeId(1);
		employeeDto.setEmployeeName("bala");
		employeeDto.setLocation("bangalore");
		employeeDto.setPassword("bala");
		employeeDto.setPhoneNumber("9705441499");
		employeeDto.setUserName("bala");
		employeeDto.setEmailId("bala.k@gmail.com");
		employeeDto1.setEmployeeId(2);
		employeeDto1.setEmployeeName("suresh");
		employeeDto1.setLocation("ecity");
		employeeDto1.setPassword("suresh");
		employeeDto1.setPhoneNumber("9705441400");
		employeeDto1.setUserName("suresh");
		employee1.setEmailId("suresh.k@gmail.com");
		
		employeeDtoList.add(employeeDto);
		employeeDtoList.add(employeeDto1);
		
		Mockito.when(employeeRepository.findAll()).thenReturn(employeeList);
		employeeResponseDto = employeeServiceImpl.getAllEmployees();
		Assert.assertNotNull(employeeResponseDto);
		Assert.assertEquals(ApplicationConstants.LIST_OF_EMPLOYEES, employeeResponseDto.getStatusMessage());
		
	}
	
	

}
