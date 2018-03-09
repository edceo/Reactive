package com.nevalabs.reactive.handlers;

import com.nevalabs.reactive.model.Employee;
import com.nevalabs.reactive.model.EmployeeEvent;
import com.nevalabs.reactive.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class RouterHandlers {

    @Autowired
    private EmployeeService employeeService;

    public Mono<ServerResponse> getAll(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(employeeService.getAllEmployees(), Employee.class);
    }

    public Mono<ServerResponse> getId(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(employeeService.getEmployeeById(serverRequest.pathVariable("id")), Employee.class);
    }

    public Mono<ServerResponse> getEvents(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(employeeService.getEmployeeEvents(serverRequest.pathVariable("id")), EmployeeEvent.class);
    }
}
