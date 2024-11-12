package de.fspeer.backend.controller;

import de.fspeer.backend.models.Guest;
import de.fspeer.backend.models.GuestDTO;
import de.fspeer.backend.service.GuestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/guest")
public class GuestController {

    private final GuestService guestService;

    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping
    public List<Guest> findAll() {
        return guestService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Guest> findById(@PathVariable String id) {
        return guestService.findById(id);
    }

    @PostMapping
    public Guest saveGuest(@RequestBody GuestDTO guestDTO) {
        return guestService.saveGuest(guestDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteGuestById(@PathVariable String id){
        guestService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Guest updateGuest(@RequestBody Guest guest, @PathVariable String id) {
        return guestService.updateGuest(guest, id);
    }
}
