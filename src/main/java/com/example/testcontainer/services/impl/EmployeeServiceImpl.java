package com.example.testcontainer.services.impl;

import com.example.testcontainer.models.Employee;
import com.example.testcontainer.repositories.EmployeeRepository;
import com.example.testcontainer.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findByName(String name) {
        return employeeRepository.findByName(name);
    }

    @Override
    public void delete(UUID id) {
        employeeRepository.deleteById(id);
    }
}
