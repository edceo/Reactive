package com.nevalabs.reactive;

import com.nevalabs.reactive.model.Employee;
import com.nevalabs.reactive.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class ReactiveApplication {

	@Bean
	CommandLineRunner insertEmployees(EmployeeRepository employeeRepository) {
		return args -> {
			employeeRepository.deleteAll().subscribe(null, null, () -> {
				Stream.of(new Employee(UUID.randomUUID().toString(), "Petrov", 24000L),
						new Employee(UUID.randomUUID().toString(), "Skorzechy", 30000L),
						new Employee(UUID.randomUUID().toString(), "Markhel", 27000L),
						new Employee(UUID.randomUUID().toString(), "Sam", 34000L),
						new Employee(UUID.randomUUID().toString(), "Frodo", 42000L)
				).forEach(employee -> employeeRepository
                        .save(employee)
                        .subscribe(System.out::println));
			});
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ReactiveApplication.class, args);
	}
}
