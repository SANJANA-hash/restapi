package com.examly.springapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data; // ✅ Lombok @Data annotation
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "events")
@Data  // ✅ This ensures getters, setters, toString, equals, and hashCode methods are auto-generated
public class Event {

    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Long id;

                private String eventName;

                    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
                        @JsonIgnore // ✅ Prevents infinite recursion when serializing JSON
                            private List<Task> tasks;

                            }