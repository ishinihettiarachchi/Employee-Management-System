package com.project1.employeemanagementsystem.service;

import com.project1.employeemanagementsystem.DTO.EmployeeDTO;
import com.project1.employeemanagementsystem.DTO.EmployeeUpdateDTO;

import java.util.List;

public interface EmployeeService {
    void saveEmployee(EmployeeDTO employeeDTO);

    List<EmployeeDTO> getAllEmployees();

    String deleteEmployee(int employeeId);


    EmployeeDTO getEmployeeById(int employeeId);

    String updateEmployee(int employeeId, EmployeeUpdateDTO employeeUpdateDTO);
}