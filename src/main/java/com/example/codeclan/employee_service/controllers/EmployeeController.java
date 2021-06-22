package com.example.codeclan.employee_service.controllers;

import com.example.codeclan.employee_service.models.Employee;
import com.example.codeclan.employee_service.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping(value = "/pirates")
    public List<Employee> getAllPirates(){
        return  employeeRepository.findAll();
    }

    @GetMapping(value = "/pirates/{id}")
    public Optional<Employee> getPirate(@PathVariable Long id){
        return employeeRepository.findById(id);
    }
}
