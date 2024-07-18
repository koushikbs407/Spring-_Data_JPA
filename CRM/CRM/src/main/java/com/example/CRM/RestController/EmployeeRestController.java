package com.example.CRM.RestController;


import com.example.CRM.EmployeService.EmployeeService;
import com.example.CRM.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

   @Autowired
   private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome";
    }

    @GetMapping("/employee")
    public List<Employee> getEmployees() {
        return employeeService.getAllEmployees();

    }

    @GetMapping("/employee/{employeeID}")
    public Employee getEmployee(@PathVariable int employeeID) {

        Employee employee = employeeService.findEmployeeById(employeeID);
        if (employee == null) {
            throw new RuntimeException("employee donesnt exit with respect to the id" + employeeID);
        }

        return employee;
    }

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setId(0);
        Employee newemployee = employeeService.addEmployee(employee);
        return newemployee;
    }

    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee employee) {
        Employee updatedemplyee = employeeService.addEmployee(employee);
        return updatedemplyee;
    }

    @DeleteMapping("/employee/{emplyeeId}")
    public String deleteEmployee(@PathVariable int emplyeeId) {
        Employee employee = employeeService.deleteEmployeeById(emplyeeId);
        if (employee == null) {
            throw new RuntimeException("employee donesnt exit");
        }
        return  "employee deleted  " + emplyeeId;
    }





}
