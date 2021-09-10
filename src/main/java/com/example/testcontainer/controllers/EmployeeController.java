package com.example.testcontainer.controllers;

import com.example.testcontainer.models.Employee;
import com.example.testcontainer.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping(value = {"/employee"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Employee save(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @GetMapping(value = {"/employee"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Employee findByName(@RequestParam String name) {
        return employeeService.findByName(name);
    }

    @DeleteMapping(value = {"/employee"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public void delete(@RequestParam UUID id) {
        employeeService.delete(id);
    }
}
