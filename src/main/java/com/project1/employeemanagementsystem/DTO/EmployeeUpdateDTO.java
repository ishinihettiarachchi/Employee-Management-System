package com.project1.employeemanagementsystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeUpdateDTO {

    private int employeeId;
    private String employeeName;
    private String employeeEmail;
    private String employeeAddress;
    private double employeeSalary;


}
