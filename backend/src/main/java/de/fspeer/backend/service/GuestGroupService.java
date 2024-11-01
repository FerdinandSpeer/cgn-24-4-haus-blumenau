package de.fspeer.backend.service;

import de.fspeer.backend.models.Guest;
import de.fspeer.backend.models.GuestGroup;
import de.fspeer.backend.repository.GuestGroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class GuestGroupService {

    private final GuestGroupRepository guestGroupRepository;
    private final IdService idService;

    public GuestGroupService(GuestGroupRepository guestGroupRepository, IdService idService) {
        this.guestGroupRepository = guestGroupRepository;
        this.idService = idService;
    }

    public GuestGroup createGuestGroup(List<Guest> guests) {
        List<Guest> guestsWithId = guests.stream().map(guest -> guest.withGuestId(idService.generateId())).toList();
        return guestGroupRepository.save(new GuestGroup(idService.generateId(), guestsWithId));
    }

    public GuestGroup findByGroupId(String Id) {
        return guestGroupRepository.findById(Id).orElseThrow(() -> new NoSuchElementException("GuestGroup not found"));
    }

    public List<GuestGroup> findAll() {
        return guestGroupRepository.findAll();
    }

    public void deleteGuestGroupById(String id) {
        guestGroupRepository.deleteById(id);
    }

    public GuestGroup update(String id, GuestGroup guestGroup) {
        guestGroupRepository.findById(id);
        return guestGroupRepository.save(guestGroup);
    }

    public GuestGroup deleteGuestFromGuestGroup(String id, String guestId) {
    GuestGroup guestGroupToUpdate = guestGroupRepository.findById(id).orElseThrow();
    List<Guest> tempList = guestGroupToUpdate.guests().stream().filter(guest -> !guest.guestId().equals(guestId)).toList();
    guestGroupRepository.save(guestGroupToUpdate.withGuests(tempList));
    return guestGroupRepository.findById(id).orElseThrow();
    }
}
