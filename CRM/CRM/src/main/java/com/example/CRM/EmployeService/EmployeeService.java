package com.example.CRM.EmployeService;

import com.example.CRM.Entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee findEmployeeById(int id);
    Employee addEmployee(Employee employee);
    Employee deleteEmployeeById(int id);
}
