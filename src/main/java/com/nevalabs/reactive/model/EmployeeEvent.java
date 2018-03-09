package com.nevalabs.reactive.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Document
@Data
public class EmployeeEvent {

    private Employee employee;
    private Date date;

    //public EmployeeEvent(Employee employee, Date date) {
    //    this.employee = employee;
    //    this.date = date;
    //}
}
