package com.example.CRM.EmployeService;


import com.example.CRM.Entity.Employee;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements  EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findEmployeeById(int id) {
        return employeeRepository.getReferenceById(id);
    }

    @Override

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override

    public Employee deleteEmployeeById(int id) {

        Optional<Employee> result = employeeRepository.findById(id);
        Employee employee = null;
        if (result.isPresent()) {
             employee = result.get();

        }else {
            throw new RuntimeException("Employee not found");
        }
        return employee;
    }
}
