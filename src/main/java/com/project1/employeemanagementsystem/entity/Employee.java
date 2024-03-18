package com.project1.employeemanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name="employee_id",length = 45)
    private int employeeId;

    @Column(name="employee_name", length=100,nullable = false)
    private String employeeName;

    @Column(name="employee_email")
    private String employeeEmail;

    @Column(name="employee_address")
    private String employeeAddress;

    @Column(name = "employee_salary")
    private double employeeSalary;

    @Column(name="nic")
    private String nic;

}
