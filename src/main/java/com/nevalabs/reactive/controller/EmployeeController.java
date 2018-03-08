package com.nevalabs.reactive.controller;

import com.nevalabs.reactive.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping("/all")
    public List<Employee> getAll() {

        return null;
    }
}
