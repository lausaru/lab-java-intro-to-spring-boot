package controller;

import model.Employee;
import model.EmployeeStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.EmployeeService;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Optional<Employee> findByEmployeeId(@PathVariable int employeeId) {
        return employeeService.findByEmployeeId(employeeId);
    }

    @GetMapping("/employees/department/{department}")
    public List<Employee> findByDepartment(@PathVariable String department) {
        return employeeService.findAllByDepartment(department);
    }

    @GetMapping("/employees/status/{status}")
    public List<Employee> findByStatus(@PathVariable EmployeeStatus status) {
        return employeeService.findAllByStatus(status);
    }


}