package com.examly.springapp.service;

import com.examly.springapp.model.Event;
import com.examly.springapp.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
        private EventRepository eventRepository;

            public List<Event> getAllEvents() {
                    return eventRepository.findAll();
                        }

                            public Optional<Event> getEventById(Long id) {
                                    return eventRepository.findById(id);
                                        }

                                            public Event createOrUpdateEvent(Event event) {
                                                    Event savedEvent = eventRepository.save(event);
                                                            return savedEvent; // ✅ Ensure ID is set before returning
                                                                }

                                                                    public void deleteEvent(Long id) {
                                                                            eventRepository.deleteById(id);
                                                                                }
                                                                                }