package com.hcl.crudoperation.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.crudoperation.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	public Optional<Employee> findByEmployeeId(Integer employeeId);
	
	public Optional<List<Employee>> findByEmployeeNameContains(String emloyeeName);

}
