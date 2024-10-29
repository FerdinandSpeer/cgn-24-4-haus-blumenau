package de.fspeer.backend.service;

import de.fspeer.backend.models.Guest;
import de.fspeer.backend.models.GuestDTO;
import de.fspeer.backend.repository.GuestRepository;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class GuestServiceTest {

    private final GuestRepository guestRepository = mock(GuestRepository.class);
    private final IdService idService = mock(IdService.class);


    @Test
    void findAll() {
        List<Guest> expectedGuestList = List.of(new Guest("1", "test", "test", "test", "test", "test", "test", "test", "test", "test", 1,"test","test","test"));
        when(guestRepository.findAll()).thenReturn(expectedGuestList);

        GuestService guestService = new GuestService(guestRepository, idService);

        List<Guest> actualGuestList = guestService.findAll();
        verify(guestRepository).findAll();
        assertEquals(actualGuestList, expectedGuestList);
    }

    @Test
    void findById() {
        Guest expectedGuest = new Guest("1", "test", "test", "test", "test", "test", "test", "test", "test", "test", 1,"test","test","test");
        when(guestRepository.findById("1")).thenReturn(Optional.of(expectedGuest));

        GuestService guestService = new GuestService(guestRepository, idService);

        Guest actualGuest = guestService.findById("1").orElseThrow();
        verify(guestRepository).findById("1");
        assertEquals(actualGuest, expectedGuest);
    }

    @Test
    void saveGuest() {
        Guest expectedGuest = new Guest("1", "test", "test", "test", "test", "test", "test", "test", "test", "test", 1,"test","test","test");
        when(guestRepository.save(any(Guest.class))).thenReturn(expectedGuest);
        GuestService guestService = new GuestService(guestRepository, idService);

        Guest actualGuest = guestService.saveGuest(new GuestDTO("test", "test", "test", "test", "test", "test", "test", "test", "test", 1,"test","test","test"));
        verify(guestRepository).save(any(Guest.class));
        assertEquals(actualGuest, expectedGuest);
    }

@Test
void updateGuest() {
    Guest updatedGuest = new Guest("1", "test", "test", "test", "Frank", "test", "test", "test", "test", "test", 1, "test", "test", "test");
    when(guestRepository.existsById("1")).thenReturn(true);
    when(guestRepository.save(any(Guest.class))).thenReturn(updatedGuest);
    GuestService guestService = new GuestService(guestRepository, idService);

    Guest actualGuest = guestService.updateGuest(updatedGuest, "1");
    verify(guestRepository).existsById("1");
    verify(guestRepository).save(any(Guest.class));
    assertEquals(actualGuest, updatedGuest);
}}