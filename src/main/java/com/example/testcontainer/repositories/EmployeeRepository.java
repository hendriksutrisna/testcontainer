package com.example.testcontainer.repositories;

import com.example.testcontainer.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
    Employee findByName(String name);
}
