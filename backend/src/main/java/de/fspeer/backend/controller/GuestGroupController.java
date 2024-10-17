package de.fspeer.backend.controller;

import de.fspeer.backend.models.Guest;
import de.fspeer.backend.models.GuestGroup;
import de.fspeer.backend.service.GuestGroupService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guest-group")
public class GuestGroupController {

    private final GuestGroupService guestGroupService;

    public GuestGroupController(GuestGroupService guestGroupService) {
        this.guestGroupService = guestGroupService;
    }

    @GetMapping("/{id}")
    public List<Guest> findByGroupId(@PathVariable String id) {
        return guestGroupService.findByGroupId(id);
    }

    @PostMapping
    public GuestGroup createGuestGroup(@RequestBody List<Guest> guests) {
        return guestGroupService.createGuestGroup(guests);
    }
}
