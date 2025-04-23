package com.examly.springapp.service;

import com.examly.springapp.model.Employee;
import com.examly.springapp.model.Task;
import com.examly.springapp.repository.EmployeeRepository;
import com.examly.springapp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
 private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);
    private static final String LOG_FOLDER_PATH = "logs";
    private static final String LOG_FILE_PATH = "logs/application.log";
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private TaskRepository taskRepository;
public EmployeeService() {
    createLogDirectoryAndFile(); 
}
private void createLogDirectoryAndFile() {
 try {
    File logFolder = new File(LOG_FOLDER_PATH);
    if (!logFolder.exists()) {
        boolean folderCreated = logFolder.mkdir();
        if (folderCreated) {
        logger.info("Log folder created successfully.");
        }
    }
File logFile = new File(LOG_FILE_PATH);
if (!logFile.exists()) {
    boolean fileCreated = logFile.createNewFile();
     if (fileCreated) {
logger.info("Log file created successfully.");
     }
}
} catch (IOException e) {
     logger.error("Error creating log folder or file: ", e);
 }
}
public List<Employee> getAllEmployees() {
 return employeeRepository.findAll();
}
public Optional<Employee> getEmployeeById(Long id) {
    return employeeRepository.findById(id);
}
public Employee createOrUpdateEmployee(Employee employee) {
 if (employee.getTask() == null || employee.getTask().getId() == null) {
 throw new IllegalArgumentException("Task cannot be null or must have a valid ID");
 }
    Task task = taskRepository.findById(employee.getTask().getId())
    .orElseThrow(() -> new IllegalArgumentException("Task ID " + employee.getTask().getId() + " not found"));
     employee.setTask(task);
    return employeeRepository.save(employee);
}
public void deleteEmployee(Long id) {
    employeeRepository.deleteById(id);
}
}
                                                                                                                                                                                                                                                                                                                                                                                                                                    
                                                                                                                                                                                                                                                                                                                                                                                                                                    
