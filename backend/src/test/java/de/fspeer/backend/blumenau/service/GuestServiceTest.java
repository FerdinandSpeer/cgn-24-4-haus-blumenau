package de.fspeer.backend.blumenau.service;

import de.fspeer.backend.blumenau.models.Guest;
import de.fspeer.backend.blumenau.models.GuestDTO;
import de.fspeer.backend.blumenau.repository.GuestRepository;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GuestServiceTest {

    private final GuestRepository guestRepository = mock(GuestRepository.class);
    private final IdService idService = mock(IdService.class);

    @Test
    void findAll() {
        List<Guest> expectedGuestList = List.of(new Guest("1", "test",
                "test", "test", "test", "test",
                "test", 1, "test", "test",
                "test"));
        when(guestRepository.findAll()).thenReturn(expectedGuestList);

        GuestService guestService = new GuestService(guestRepository, idService);

        List<Guest> actualGuestList = guestService.findAll();
        verify(guestRepository).findAll();
        assertEquals(actualGuestList, expectedGuestList);
    }

    @Test
    void findById() {
        Guest expectedGuest = new Guest("1", "test",
                "test", "test", "test", "test",
                "test", 1, "test", "test",
                "test");
        when(guestRepository.findById("1")).thenReturn(Optional.of(expectedGuest));

        GuestService guestService = new GuestService(guestRepository, idService);

        Guest actualGuest = guestService.findById("1");
        verify(guestRepository).findById("1");
        assertEquals(actualGuest, expectedGuest);
    }

    @Test
    void saveGuest() {
        Guest expectedGuest = new Guest("1", "test", "test", "test", "test", "test", "test", 1, "test", "test", "test");
        when(guestRepository.save(any(Guest.class))).thenReturn(expectedGuest);
        when(idService.generateId()).thenReturn("1");
        GuestService guestService = new GuestService(guestRepository, idService);

        Guest actualGuest = guestService.saveGuest(new GuestDTO("test", "test", "test", "test", "test", "test", 1, "test", "test", "test"));
        verify(guestRepository).save(any(Guest.class));
        assertEquals(actualGuest, expectedGuest);
    }

    @Test
    void updateGuest() {
        Guest expectedGuest = new Guest("1", "test",
                "test", "test", "test", "test",
                "test", 1, "test", "test",
                "test");
        when(guestRepository.findById("1")).thenReturn(Optional.of(new Guest("1",
                "test123", "test", "test", "test", "test",
                "test", 1, "test", "test",
                "test")));
        when(guestRepository.save(any(Guest.class))).thenReturn(expectedGuest);

        GuestService guestService = new GuestService(guestRepository, idService);

        Guest actualGuest = guestService.updateGuest(new GuestDTO("test",
                "test", "test", "test", "test", "test",
                1, "test", "test", "test"), "1");
        verify(guestRepository).save(any(Guest.class));
        assertEquals(actualGuest, expectedGuest);
    }

}