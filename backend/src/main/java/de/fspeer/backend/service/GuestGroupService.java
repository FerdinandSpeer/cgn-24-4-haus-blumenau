package de.fspeer.backend.service;

import de.fspeer.backend.models.GuestDTO;
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

    public GuestGroup createGuestGroup(List<GuestDTO> guestsDTO) {
        return guestGroupRepository.save(new GuestGroup(idService.generateId(),guestsDTO));
    }

    public GuestGroup findByGroupId(String Id) {
        return guestGroupRepository.findById(Id).orElseThrow(()-> new NoSuchElementException("GuestGroup not found"));
    }


    public List<GuestGroup> findAll() {
        return guestGroupRepository.findAll();
    }
}
