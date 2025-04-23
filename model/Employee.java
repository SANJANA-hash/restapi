package com.examly.springapp.model;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Long id;

                private String employeeName;
                    private String designation;

                        @ManyToOne
                            @JoinColumn(name = "task_id", nullable = false) // ✅ Ensure this is mapped
                                private Task task;

                                    public Employee() {}

                                        public Employee(Long id, String employeeName, String designation, Task task) {
                                                this.id = id;
                                                        this.employeeName = employeeName;
                                                                this.designation = designation;
                                                                        this.task = task;
                                                                            }

                                                                                public Long getId() {
                                                                                        return id;
                                                                                            }

                                                                                                public void setId(Long id) {
                                                                                                        this.id = id;
                                                                                                            }

                                                                                                                public String getEmployeeName() {
                                                                                                                        return employeeName;
                                                                                                                            }

                                                                                                                                public void setEmployeeName(String employeeName) {
                                                                                                                                        this.employeeName = employeeName;
                                                                                                                                            }

                                                                                                                                                public String getDesignation() {
                                                                                                                                                        return designation;
                                                                                                                                                            }

                                                                                                                                                                public void setDesignation(String designation) {
                                                                                                                                                                        this.designation = designation;
                                                                                                                                                                            }

                                                                                                                                                                                public Task getTask() {
                                                                                                                                                                                        return task;
                                                                                                                                                                                            }

                                                                                                                                                                                                public void setTask(Task task) {
                                                                                                                                                                                                        this.task = task;
                                                                                                                                                                                                            }
                                                                                                                                                                                                            }