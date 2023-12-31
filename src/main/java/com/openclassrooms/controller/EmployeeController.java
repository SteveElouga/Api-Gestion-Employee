package com.openclassrooms.controller;

import com.openclassrooms.model.Employee;
import com.openclassrooms.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public Iterable<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping("/employee/{id}")
    public  Employee getEmployee(@PathVariable("id") final Long id){
        Optional<Employee> employee = employeeService.getEmployee(id);
        if(employee.isPresent()){
            return employee.get();
        }else{
            return null;
        }
    }

    @PutMapping("/employee/{id}")
    public Employee updateEmployee(@PathVariable("id") final Long id, @RequestBody Employee employee) {
        Optional<Employee> e = employeeService.getEmployee(id);
        if(e.isPresent()) {
            Employee currentEmployee = e.get();

            String firstName = employee.getFirstname();
            if(firstName != null) {
                currentEmployee.setFirstname(firstName);
            }
            String lastName = employee.getLastname();
            if(lastName != null) {
                currentEmployee.setLastname(lastName);;
            }
            String mail = employee.getMail();
            if(mail != null) {
                currentEmployee.setMail(mail);
            }
            String password = employee.getPassword();
            if(password != null) {
                currentEmployee.setPassword(password);;
            }
            employeeService.saveEmployee(currentEmployee);
            return currentEmployee;
        } else {
            return null;
        }
    }

    @PostMapping("/create")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable("id") final  Long id){
        employeeService.deleteEmployee(id);
    }
}
