package com.nevalabs.reactive.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Document
@Data
public class Employee {

    @Id
    private String id;
    private String name;
    private Long salary;

    //public Employee(String id, String name, long salary) {
    //    this.id = id;
    //    this.name = name;
    //    this.salary = salary;
    //}
}
