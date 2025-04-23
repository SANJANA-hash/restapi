package com.examly.springapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore; // ✅ Import JsonIgnore

import javax.persistence.*;

@Entity
@Table(name = "guests") 
public class Guest {

    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Long id;

                private String name;
                    private String email;

                        @ManyToOne
                            @JoinColumn(name = "event_id", nullable = false)
                                @JsonIgnore // ✅ Prevents infinite recursion in JSON responses
                                    private Event event;

                                        public Guest() {
                                            }

                                                public Guest(Long id, String name, String email, Event event) {
                                                        this.id = id;
                                                                this.name = name;
                                                                        this.email = email;
                                                                                this.event = event;
                                                                                    }

                                                                                        public Long getId() {
                                                                                                return id;
                                                                                                    }

                                                                                                        public void setId(Long id) {
                                                                                                                this.id = id;
                                                                                                                    }

                                                                                                                        public String getName() {
                                                                                                                                return name;
                                                                                                                                    }

                                                                                                                                        public void setName(String name) {
                                                                                                                                                this.name = name;
                                                                                                                                                    }

                                                                                                                                                        public String getEmail() {
                                                                                                                                                                return email;
                                                                                                                                                                    }

                                                                                                                                                                        public void setEmail(String email) {
                                                                                                                                                                                this.email = email;
                                                                                                                                                                                    }

                                                                                                                                                                                        public Event getEvent() {
                                                                                                                                                                                                return event;
                                                                                                                                                                                                    }

                                                                                                                                                                                                        public void setEvent(Event event) {
                                                                                                                                                                                                                this.event = event;
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                    }