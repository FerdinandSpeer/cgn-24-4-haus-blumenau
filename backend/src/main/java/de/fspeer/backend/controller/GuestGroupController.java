package de.fspeer.backend.controller;

import de.fspeer.backend.models.Guest;
import de.fspeer.backend.models.GuestGroup;
import de.fspeer.backend.service.GuestGroupService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/guestGroup")
public class GuestGroupController {

    private final GuestGroupService guestGroupService;

    public GuestGroupController(GuestGroupService guestGroupService) {
        this.guestGroupService = guestGroupService;
    }

    @GetMapping
    public List<GuestGroup> findAll() {
        return guestGroupService.findAll();
    }
    @GetMapping("/{Id}")
    public GuestGroup findByGroupId(@PathVariable String Id) {
        return guestGroupService.findByGroupId(Id);
    }

    @PostMapping
    public GuestGroup createGuestGroup(@RequestBody List<Guest> guests) {
        return guestGroupService.createGuestGroup(guests);
    }

    @DeleteMapping("/{id}")
    public void deleteGuestGroupById(@PathVariable String id) {
        guestGroupService.deleteGuestGroupById(id);
    }

    @PutMapping("/{id}/{guestId}")
    public GuestGroup deleteGuestByGuestIdFromGuestGroup(@PathVariable String id, @PathVariable String guestId) {
        return guestGroupService.deleteGuestFromGuestGroup(id, guestId);
    }

    @PutMapping("/{id}")
    public GuestGroup update(@PathVariable String id, @RequestBody GuestGroup guestGroup) {
        return guestGroupService.update(id, guestGroup);
    }

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNoSuchElementException(NoSuchElementException e) {
        return e.getMessage();
    }

}
