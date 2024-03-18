package com.project1.employeemanagementsystem.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeDTO {
    private int employeeId;
    private String employeeName;
    private String employeeEmail;
    private String employeeAddress;
    private double employeeSalary;
    private String nic;
}
