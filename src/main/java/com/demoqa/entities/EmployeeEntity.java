package com.demoqa.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder

public class EmployeeEntity {

    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private long salary;
    private String department;
}
