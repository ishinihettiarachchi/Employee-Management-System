package com.project1.employeemanagementsystem.controller;
import com.project1.employeemanagementsystem.DTO.EmployeeDTO;
import com.project1.employeemanagementsystem.DTO.EmployeeUpdateDTO;
import com.project1.employeemanagementsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
@CrossOrigin
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(path="/save")
    public String saveEmployee(@RequestBody EmployeeDTO employeeDTO){
        employeeService.saveEmployee(employeeDTO);
        return "saved";
    }

    @GetMapping(path = "/get-all-employees")
    public List<EmployeeDTO> getAllEmployees(){
        List<EmployeeDTO> employees =  employeeService.getAllEmployees();
        return employees;
    }

    @GetMapping(path = "/get-employee/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable(value = "id") int employeeId){
        EmployeeDTO employee =  employeeService.getEmployeeById(employeeId);
        return employee;

    }

    @DeleteMapping(path = "delete-employee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") int employeeId){
        String deleted = employeeService.deleteEmployee(employeeId);
        return deleted;
    }

    @PutMapping(path = "update-employee/{id}")
    public String updateEmployee(@PathVariable(value = "id") int employeeId,@RequestBody EmployeeUpdateDTO employeeUpdateDTO){
        employeeService.updateEmployee(employeeId,employeeUpdateDTO);
        return "updated";
    }

}
