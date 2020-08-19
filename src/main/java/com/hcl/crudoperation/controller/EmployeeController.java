package com.hcl.crudoperation.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.crudoperation.dto.EmployeeRequestDto;
import com.hcl.crudoperation.dto.EmployeeResponseDto;
import com.hcl.crudoperation.dto.ResponseDto;
import com.hcl.crudoperation.entity.Employee;
import com.hcl.crudoperation.exception.EmployeeNotFoundException;
import com.hcl.crudoperation.service.EmployeeService;

/**
 * 
 * @author Bala Suresh Krishna. K
 * @apiNote This api is for performing crud operations
 *
 */

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	private static Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	

	/**
	 * 
	 * @param employeeRequestDto
	 * @return ResponseDto
	 * @apiOperation
	 * @apiResponses
	 */
	
	@PostMapping("")
	public ResponseEntity<ResponseDto> addEmployee(@Valid @RequestBody EmployeeRequestDto employeeRequestDto) {
		logger.info("inside employee controller add employee method: ");
		ResponseDto responseDto;
		responseDto = employeeService.addEmployee(employeeRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.CREATED);

	}
	
	/**
	 * 
	 * @return EmployeeResponseDto
	 * @apiNote this api is for displaying list of all employees
	 */
	@GetMapping("")
	public ResponseEntity<EmployeeResponseDto> getAllEmployees() {
		logger.info("inside employee controller get all employees method: ");
		EmployeeResponseDto employeeResponseDto;
		logger.info("inside employee controller: ");
		employeeResponseDto = employeeService.getAllEmployees();
		return new ResponseEntity<EmployeeResponseDto>(employeeResponseDto, HttpStatus.OK);
	}

	/**
	 * 
	 * @param employeeName
	 * @return EmployeeResonseDto
	 * @throws EmployeeNotFoundException
	 * @apiNote this api is for displaying the list of employees based on search string
	 */
	@GetMapping("/")
	public ResponseEntity<EmployeeResponseDto> searchEmployees(@RequestParam String employeeName) throws EmployeeNotFoundException {
		logger.info("inside employee controller: ");
		EmployeeResponseDto employeeResponseDto;
		employeeResponseDto = employeeService.searchEmployees(employeeName);
		return new ResponseEntity<EmployeeResponseDto>(employeeResponseDto, HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param id
	 * @param employee
	 * @return ResponseDto
	 * @throws EmployeeNotFoundException
	 * @apiNote this api is for updating the employee details based on the id
	 */
	@PostMapping("/{id}")
	public ResponseEntity<ResponseDto> updateEmployee(@PathVariable Integer id, @Valid @RequestBody Employee employee) throws EmployeeNotFoundException {
		 
		logger.info("inside employee controller update method: ");
		ResponseDto responseDto;
		responseDto = employeeService.updateEmployee(id, employee);
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param id
	 * @return ResponseDto
	 * @throws EmployeeNotFoundException
	 * @apiNote this api is for deleting the employee details based on the id
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseDto> deleteById(@PathVariable Integer id) throws EmployeeNotFoundException {
		logger.info("inside employee controller delete method: ");
		ResponseDto responseDto;
		responseDto = employeeService.deleteEmployee(id);
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}

}
