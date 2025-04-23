package com.examly.springapp.controller;

import com.examly.springapp.model.Event;
import com.examly.springapp.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/events") // ✅ Fixed path to match test case
public class EventController {

    @Autowired
        private EventService eventService;

            @GetMapping
                public List<Event> getAllEvents() {
                        return eventService.getAllEvents();
                            }

                                @GetMapping("/{id}")
                                    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
                                            Optional<Event> event = eventService.getEventById(id);
                                                    return event.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
                                                        }

                                                            @PostMapping
                                                                public ResponseEntity<Event> createEvent(@RequestBody Event event) {
                                                                        Event savedEvent = eventService.createOrUpdateEvent(event);
                                                                                return ResponseEntity.status(201).body(savedEvent); // ✅ Ensure created status is sent
                                                                                    }

                                                                                        @DeleteMapping("/{id}")
                                                                                            public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
                                                                                                    eventService.deleteEvent(id);
                                                                                                            return ResponseEntity.noContent().build();
                                                                                                                }
                                                                                                                }