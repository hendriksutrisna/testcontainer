package com.example.testcontainer.services;

import com.example.testcontainer.models.Employee;

import java.util.UUID;

public interface EmployeeService {
    Employee save(Employee employee);
    Employee findByName(String name);
    void delete (UUID id);
}
