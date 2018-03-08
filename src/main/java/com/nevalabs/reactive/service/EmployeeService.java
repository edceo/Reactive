package com.nevalabs.reactive.service;

import com.nevalabs.reactive.model.Employee;
import com.nevalabs.reactive.model.EmployeeEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeService {

    Flux<Employee> getAllEmployees();

    Mono<Employee> getEmployeeById(String id);

    Flux<EmployeeEvent> getEmployeeEvents(String id);
}
