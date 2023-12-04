package com.openclassrooms.service;

import com.openclassrooms.model.Employee;
import com.openclassrooms.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;

import java.util.Optional;

@Data
@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Optional<Employee> getEmployee(final Long id){
		return employeeRepository.findById(id);
	}

	public Iterable<Employee> getEmployees(){
		return employeeRepository.findAll();
	}

	public void deleteEmployee(final Long id){
		employeeRepository.deleteById(id);
	}

	public Employee saveEmployee(Employee employee){
		Employee saveEmployee = employeeRepository.save(employee);
		return saveEmployee;
	}
}
