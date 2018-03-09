package com.nevalabs.reactive.controller;

import com.nevalabs.reactive.model.Employee;
import com.nevalabs.reactive.model.EmployeeEvent;
import com.nevalabs.reactive.repository.EmployeeRepository;
import com.nevalabs.reactive.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public Flux<Employee> getAll() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Mono<Employee> getEmployee(@PathVariable("id") final String id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping(value = "/{id}/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<EmployeeEvent> getEvents(@PathVariable("id") final String id) {
        return employeeService.getEmployeeEvents(id);
    }
}
