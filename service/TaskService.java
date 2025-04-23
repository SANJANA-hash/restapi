package com.examly.springapp.service;

import com.examly.springapp.model.Task;
import com.examly.springapp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
        private TaskRepository taskRepository;

            public List<Task> getAllTasks() {
                    return taskRepository.findAll();
                        }

                            public Task getTaskById(Long id) {
                                    return taskRepository.findById(id).orElse(null); // ✅ Return null if task not found
                                        }

                                            public Task createTask(Task task) {
                                                    return taskRepository.save(task);
                                                        }

                                                            public void deleteTask(Long id) {
                                                                    if (taskRepository.existsById(id)) {
                                                                                taskRepository.deleteById(id);
                                                                                        }
                                                                                            }
                                                                                            }