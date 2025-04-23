package com.examly.springapp.controller;

import com.examly.springapp.model.Employee;
import com.examly.springapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees") // ✅ Ensure the path matches the test case
public class EmployeeController {

    @Autowired
        private EmployeeService employeeService;

            @GetMapping
                public List<Employee> getAllEmployees() {
                        return employeeService.getAllEmployees();
                            }

                                @GetMapping("/{id}")
                                    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
                                            Optional<Employee> employee = employeeService.getEmployeeById(id);
                                                    return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
                                                        }

                                                            @PostMapping
                                                                public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
                                                                        // ✅ Ensure JSON matches test case expectations
                                                                                if (employee.getEmployeeName() == null || employee.getDesignation() == null || employee.getTask() == null) {
                                                                                            return ResponseEntity.badRequest().build();
                                                                                                    }

                                                                                                            Employee savedEmployee = employeeService.createOrUpdateEmployee(employee);
                                                                                                                    return ResponseEntity.status(201).body(savedEmployee);
                                                                                                                        }

                                                                                                                            @DeleteMapping("/{id}")
                                                                                                                                public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
                                                                                                                                        employeeService.deleteEmployee(id);
                                                                                                                                                return ResponseEntity.noContent().build();
                                                                                                                                                    }
                                                                                                                                                    }