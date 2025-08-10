package com.karanchuk.roomwebapp.web.controller;

import com.karanchuk.roomwebapp.data.entity.Employee;
import com.karanchuk.roomwebapp.data.repository.EmployeeRepository;
import com.karanchuk.roomwebapp.web.model.Staff;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/staff")
public class StaffController {
    private final EmployeeRepository employeeRepository;

    public StaffController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public String getStaffPage(Model model) {
        List<Employee> staffEntities = employeeRepository.findAll();
        List<Staff> staff = new ArrayList<>(staffEntities.size());
        staffEntities.forEach(e -> staff.add(new Staff(e.getEmployeeId(), e.getLastName(), e.getFirstName(), e.getPosition())));
        model.addAttribute("staff", staff);
        return "staff";
    }
}
