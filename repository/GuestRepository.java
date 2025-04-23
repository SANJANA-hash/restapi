package com.examly.springapp.repository;

import com.examly.springapp.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {

    // Custom query method to find Guest by name
        List<Guest> findByName(String name);
        }
        