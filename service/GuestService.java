package com.examly.springapp.service;

import com.examly.springapp.model.Guest;
import com.examly.springapp.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;

    // ✅ Get all guests with pagination & sorting
    public Page<Guest> getAllGuests(int page, int size, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        return guestRepository.findAll(pageRequest);
    }

    // ✅ Get guest by ID
    public Optional<Guest> getGuestById(Long id) {
        return guestRepository.findById(id);
    }

    // ✅ Create or update a guest
    public Guest createOrUpdateGuest(Guest guest) {
        return guestRepository.save(guest);
    }

    // ✅ Delete a guest by ID
    public void deleteGuest(Long id) {
        guestRepository.deleteById(id);
    }
}
