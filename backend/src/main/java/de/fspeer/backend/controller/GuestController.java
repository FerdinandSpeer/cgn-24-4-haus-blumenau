package de.fspeer.backend.controller;

import de.fspeer.backend.models.Guest;
import de.fspeer.backend.models.GuestDTO;
import de.fspeer.backend.service.GuestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/guest")
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
    public Guest findById(@PathVariable String id) {
        return guestService.findById(id);
    }

    @PostMapping
    GuestDTO saveGuest(@RequestBody GuestDTO guestDTO) {
        Guest newGuest = guestService.saveGuest(guestDTO);
        return newGuest.toDTO();
    }

    @PutMapping("/{id}")
    GuestDTO updateGuest(@RequestBody GuestDTO guestDTO, @PathVariable String id) {
        Guest updatedGuest = guestService.updateGuest(guestDTO, id);
        return updatedGuest.toDTO();
    }

    @DeleteMapping("/{id}")
    void deleteGuest(@PathVariable String id) {
        guestService.deleteById(id);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public String handleNotFoundException(NoSuchElementException exception) {
        return exception.getMessage();
    }
}
