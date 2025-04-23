package com.examly.springapp.controller;

import com.examly.springapp.model.Task;
import com.examly.springapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
        private TaskService taskService;

            @GetMapping
                public List<Task> getAllTasks() {
                        return taskService.getAllTasks();
                            }

                                @GetMapping("/{id}")
                                    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
                                            Task task = taskService.getTaskById(id);
                                                    return (task != null) ? ResponseEntity.ok(task) : ResponseEntity.notFound().build(); // ✅ Matches test case
                                                        }

                                                            @PostMapping
                                                                public ResponseEntity<Task> createTask(@RequestBody Task task) {
                                                                        Task savedTask = taskService.createTask(task);
                                                                                return ResponseEntity.ok(savedTask);
                                                                                    }

                                                                                        @DeleteMapping("/{id}")
                                                                                            public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
                                                                                                    taskService.deleteTask(id);
                                                                                                            return ResponseEntity.ok().build();
                                                                                                                }
                                                                                                                }