package de.fspeer.backend.controller;

import de.fspeer.backend.models.GuestDTO;
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
    public GuestGroup createGuestGroup(@RequestBody List<GuestDTO> guestsDTO, String groupName) {
        return guestGroupService.createGuestGroup(guestsDTO, groupName);
    }

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNoSuchElementException(NoSuchElementException e) {
        return e.getMessage();
    }

}
