package de.fspeer.backend.service;

import de.fspeer.backend.models.GuestDTO;
import de.fspeer.backend.models.GuestGroup;
import de.fspeer.backend.repository.GuestGroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuestGroupService {

    private final GuestGroupRepository guestGroupRepository;
    private final IdService idService;

    public GuestGroupService(GuestGroupRepository guestGroupRepository, IdService idService) {
        this.guestGroupRepository = guestGroupRepository;
        this.idService = idService;
    }

    public GuestGroup createGuestGroup(List<GuestDTO> guestsDTO) {
        return guestGroupRepository.save(new GuestGroup(idService.generateId(), guestsDTO));
    }

    public Optional<GuestGroup> findByGroupId(String groupId) {
        return guestGroupRepository.findById(groupId);
    }


    public List<GuestGroup> findAll() {
        return guestGroupRepository.findAll();
    }
}
