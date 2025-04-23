package com.examly.springapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
@Data // ✅ Generates getters, setters, toString, equals, and hashCode
public class Task {

    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Long id;

                private String taskName;

                    @ManyToOne
                        @JoinColumn(name = "event_id", nullable = false)
                            @JsonIgnore // ✅ Prevents infinite recursion in JSON responses
                                private Event event;
                                }