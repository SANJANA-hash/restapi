package com.examly.springapp.controller;

import com.examly.springapp.model.Guest;
import com.examly.springapp.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/guests") // ✅ Ensure the URL matches test case expectations
public class GuestController {

    @Autowired
    private GuestService guestService;

    // ✅ Fix: Correct pagination and sorting parameters
    @GetMapping
    public ResponseEntity<Page<Guest>> getAllGuests(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir) {
        Page<Guest> guests = guestService.getAllGuests(page, size, sortBy, sortDir);
        return ResponseEntity.ok(guests);
    }

    // ✅ Fix: Handle Optional properly
    @GetMapping("/{id}")
    public ResponseEntity<Guest> getGuestById(@PathVariable Long id) {
        Optional<Guest> guest = guestService.getGuestById(id);
        return guest.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // ✅ Fix: Use the correct service method for saving a guest
    @PostMapping
    public ResponseEntity<Guest> createGuest(@RequestBody Guest guest) {
        Guest savedGuest = guestService.createOrUpdateGuest(guest); // 🔥 Ensure this method exists in GuestService
        return ResponseEntity.status(201).body(savedGuest);
    }

    // ✅ Fix: Ensure deletion method works
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuest(@PathVariable Long id) {
        guestService.deleteGuest(id);
        return ResponseEntity.noContent().build();
    }
}
