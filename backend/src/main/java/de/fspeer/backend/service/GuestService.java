package de.fspeer.backend.service;

import de.fspeer.backend.models.Guest;
import de.fspeer.backend.models.GuestDTO;
import de.fspeer.backend.repository.GuestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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

    public Optional<Guest> findById(String id) {
        return guestRepository.findById(id);
    }

    public Guest saveGuest(GuestDTO guestDTO) {
        return guestRepository.save(guestDTO.fromDTO(idService.generateId()));
    }

    public void deleteById(String id) {
        guestRepository.deleteById(id);
    }

    public Guest updateGuest(Guest guest, String id) {
        if (guestRepository.existsById(id)) {
            return guestRepository.save(guest);
        }
        throw new NoSuchElementException("Guest not found");
    }
}
