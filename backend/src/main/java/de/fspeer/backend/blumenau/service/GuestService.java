package de.fspeer.backend.blumenau.service;

import de.fspeer.backend.blumenau.models.Guest;
import de.fspeer.backend.blumenau.models.GuestDTO;
import de.fspeer.backend.blumenau.repository.GuestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {

    private final GuestRepository guestRepository;
    private final IdService idService;


    public GuestService(GuestRepository guestRepository, IdService idService) {
        this.guestRepository = guestRepository;
        this.idService = idService;
    }

    public List<Guest> findAll() {
        return guestRepository.findAll();
    }

    public Guest findById(String id) {
        return guestRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("toDTO not found"));
    }

    public Guest saveGuest(GuestDTO guestDTO) {
        return guestRepository.save(guestDTO.fromDTO(idService.generateId()));
    }

    public Guest updateGuest(GuestDTO guestDTO, String id) {
        findById(id);
        return guestRepository.save(guestDTO.fromDTO(id));
    }

    public void deleteById(String id) {
        guestRepository.deleteById(id);
    }
}
