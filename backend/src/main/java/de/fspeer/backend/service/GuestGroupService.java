package de.fspeer.backend.service;

import de.fspeer.backend.models.Guest;
import de.fspeer.backend.models.GuestGroup;
import de.fspeer.backend.repository.GuestGroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestGroupService {

    private final GuestGroupRepository guestGroupRepository;
    private final IdService idService;

    public GuestGroupService(GuestGroupRepository guestGroupRepository, IdService idService) {
        this.guestGroupRepository = guestGroupRepository;
        this.idService = idService;
    }

    public GuestGroup createGuestGroup(List<Guest> guests) {
        return guestGroupRepository.save(new GuestGroup(idService.generateId(), guests));
    }

    public List<Guest> findByGroupId(String groupId) {
        return guestGroupRepository.findById(groupId).orElseThrow().guests();
    }


}
