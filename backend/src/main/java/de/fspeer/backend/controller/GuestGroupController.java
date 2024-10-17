package de.fspeer.backend.controller;

import de.fspeer.backend.models.GuestDTO;
import de.fspeer.backend.models.GuestGroup;
import de.fspeer.backend.service.GuestGroupService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/guest-group")
public class GuestGroupController {

    private final GuestGroupService guestGroupService;

    public GuestGroupController(GuestGroupService guestGroupService) {
        this.guestGroupService = guestGroupService;
    }

    @GetMapping
    public List<GuestGroup> findAll() {
        return guestGroupService.findAll();
    }
    @GetMapping("/{groupId}")
    public Optional<GuestGroup> findByGroupId(@PathVariable String groupId) {
        return guestGroupService.findByGroupId(groupId);
    }

    @PostMapping
    public GuestGroup createGuestGroup(@RequestBody List<GuestDTO> guestsDTO) {
        return guestGroupService.createGuestGroup(guestsDTO);
    }
}
