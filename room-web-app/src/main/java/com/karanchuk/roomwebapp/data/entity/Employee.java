package com.karanchuk.roomwebapp.data.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "EMPLOYEES")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "EMPLOYEE_ID")
    private UUID employeeId;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "POSITION")
    @Enumerated(EnumType.STRING)
    private Position position;

    public UUID getEmployeeId() {
        return employeeId;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Position getPosition() {
        return position;
    }
}
