package com.project1.employeemanagementsystem.service.impl;

import com.project1.employeemanagementsystem.DTO.EmployeeDTO;
import com.project1.employeemanagementsystem.DTO.EmployeeUpdateDTO;
import com.project1.employeemanagementsystem.entity.Employee;
import com.project1.employeemanagementsystem.repo.EmployeeRepo;
import com.project1.employeemanagementsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceIMPL implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public void saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(
                employeeDTO.getEmployeeId(),
                employeeDTO.getEmployeeName(),
                employeeDTO.getEmployeeEmail(),
                employeeDTO.getEmployeeAddress(),
                employeeDTO.getEmployeeSalary(),
                employeeDTO.getNic()
        );

        if(employeeRepo.existsById(employee.getEmployeeId())){
            throw new DuplicateKeyException("Customer already exists.");
        }else{
            employeeRepo.save(employee);
        }
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {

            List<Employee> getEmployee = employeeRepo.findAll();
            List<EmployeeDTO> customerDTOList = new ArrayList<>();
            for (Employee employee : getEmployee){
                EmployeeDTO employeeDTO = new EmployeeDTO();
                employeeDTO.setEmployeeId(employee.getEmployeeId());
                employeeDTO.setEmployeeName(employee.getEmployeeName());
                employeeDTO.setEmployeeEmail(employee.getEmployeeEmail());
                employeeDTO.setEmployeeAddress(employee.getEmployeeAddress());
                employeeDTO.setEmployeeSalary(employee.getEmployeeSalary());
                employeeDTO.setNic(employee.getNic());

                customerDTOList.add(employeeDTO);
            }
            return customerDTOList ;
        }

    @Override
    public String deleteEmployee(int employeeId) {
        if(employeeRepo.existsById(employeeId)){
            employeeRepo.deleteById(employeeId);
            return "Deleted Successfully";
        }else{
            return "Employee Not Found";
        }
    }

    @Override
    public EmployeeDTO getEmployeeById(int employeeId) {
        Employee employee = employeeRepo.getById(employeeId);
        System.out.println(employee);
        if (employee != null) {
            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setEmployeeId(employee.getEmployeeId());
            employeeDTO.setEmployeeName(employee.getEmployeeName());
            employeeDTO.setEmployeeEmail(employee.getEmployeeEmail());
            employeeDTO.setEmployeeAddress(employee.getEmployeeAddress());
            employeeDTO.setEmployeeSalary(employee.getEmployeeSalary());
            employeeDTO.setNic(employee.getNic());

            return employeeDTO;
        } else {
            throw new RuntimeException("Customer not found for that id " + employeeId);
        }
    }

    @Override
    public String updateEmployee(int employeeId, EmployeeUpdateDTO employeeUpdateDTO) {
        Employee updateEmployee = employeeRepo.getReferenceById(employeeId);

        if(updateEmployee!=null){
            updateEmployee.setEmployeeName(employeeUpdateDTO.getEmployeeName());
            updateEmployee.setEmployeeEmail(employeeUpdateDTO.getEmployeeEmail());
            updateEmployee.setEmployeeAddress(employeeUpdateDTO.getEmployeeAddress());
            updateEmployee.setEmployeeSalary(employeeUpdateDTO.getEmployeeSalary());

            employeeRepo.save(updateEmployee);
            return "updated";
        }else{
            throw new RuntimeException("Customer not found for that id " + employeeId);
        }


    }


}
