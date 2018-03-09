package com.nevalabs.reactive.service.impl;

import com.nevalabs.reactive.model.Employee;
import com.nevalabs.reactive.model.EmployeeEvent;
import com.nevalabs.reactive.repository.EmployeeRepository;
import com.nevalabs.reactive.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.util.Date;
import java.util.stream.Stream;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Flux<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Mono<Employee> getEmployeeById(String id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Flux<EmployeeEvent> getEmployeeEvents(String id) {
        return employeeRepository.findById(id)
                .flatMapMany(employee -> {
                    Flux<Long> interval = Flux.interval(Duration.ofSeconds(2));
                    Flux<EmployeeEvent> employeeEventFlux = Flux.fromStream(Stream.generate(() -> new EmployeeEvent(employee, new Date())));
                    return Flux.zip(interval, employeeEventFlux)
                        .map(Tuple2::getT2);
                });
    }
}
