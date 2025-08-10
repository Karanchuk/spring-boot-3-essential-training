package com.karanchuk.roomwebapp.data.repository;

import com.karanchuk.roomwebapp.data.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
}
