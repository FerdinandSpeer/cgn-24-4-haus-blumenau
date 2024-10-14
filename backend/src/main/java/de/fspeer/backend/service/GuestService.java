package de.fspeer.backend.service;

import de.fspeer.backend.models.Guest;
import de.fspeer.backend.models.GuestDTO;
import de.fspeer.backend.repository.GuestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {
    private final GuestRepository guestRepository;

    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public List<Guest> findAll() {
        return guestRepository.findAll();
    }

    public Guest findById(String id) {
        return guestRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("toDTO not found"));
    }

    public Guest saveGuest(GuestDTO guestDTO) {
        return guestRepository.save(guestDTO.fromDTO(IdService.generateId()));
    }

    public Guest updateGuest(GuestDTO guestDTO, String id) {
        findById(id);
        return guestRepository.save(guestDTO.fromDTO(id));
    }

    public void deleteById(String id) {
        guestRepository.deleteById(id);
    }
}