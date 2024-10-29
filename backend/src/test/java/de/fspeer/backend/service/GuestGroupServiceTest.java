package de.fspeer.backend.service;

import de.fspeer.backend.models.Guest;
import de.fspeer.backend.models.GuestGroup;
import de.fspeer.backend.repository.GuestGroupRepository;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class GuestGroupServiceTest {

    private final GuestGroupRepository guestGroupRepository = mock(GuestGroupRepository.class);
    private final IdService idService = mock(IdService.class);

    @Test
    void createGuestGroup(){
        List<Guest> expectedGuests = List.of(new Guest("test", "test", "test", "test", "test", "test", "test", "test", "test","test",1,"test","test","test"));
        GuestGroup expectedGuestGroup = new GuestGroup("1", expectedGuests);
        when(guestGroupRepository.save(new GuestGroup("1", expectedGuests)))
                .thenReturn(expectedGuestGroup);
        when(idService.generateId()).thenReturn("1");

        GuestGroup actualGuestGroup = guestGroupRepository.save(new GuestGroup("1", expectedGuests));
        verify(guestGroupRepository).save(new GuestGroup("1", expectedGuests));
        assertEquals(actualGuestGroup, expectedGuestGroup);

    }

    @Test
    void findByGroupId() {
        List<Guest> guests = List.of(new Guest("test", "test", "test", "test", "test", "test", "test", "test", "test","test",1,"test","test","test"));
        GuestGroup guestGroup = new GuestGroup("2", guests);
        when(guestGroupRepository.findById("2")).thenReturn(Optional.of(guestGroup));

        GuestGroupService guestGroupService = new GuestGroupService(guestGroupRepository, idService);

        GuestGroup actualGuestGroup = guestGroupService.findByGroupId("2");
        verify(guestGroupRepository).findById("2");
        assertEquals(actualGuestGroup.guests(), guestGroup.guests());    }

@Test
void findByGroupId_groupNotFound() {
    when(guestGroupRepository.findById("1")).thenReturn(Optional.empty());

    GuestGroupService guestGroupService = new GuestGroupService(guestGroupRepository, idService);

    assertThrows(NoSuchElementException.class, () -> guestGroupService.findByGroupId("1"));
}

@Test
    void updateById() {
        List<Guest> guests = List.of(new Guest("test", "test", "test", "test", "test", "test", "test", "test", "test","test",1,"test","test","test"));
        GuestGroup guestGroup = new GuestGroup("2", guests);
        when(guestGroupRepository.findById("2")).thenReturn(Optional.of(guestGroup));
        when(guestGroupRepository.save(guestGroup)).thenReturn(guestGroup);

        GuestGroupService guestGroupService = new GuestGroupService(guestGroupRepository, idService);

        GuestGroup actualGuestGroup = guestGroupService.update("2", guestGroup);
        verify(guestGroupRepository).findById("2");
        verify(guestGroupRepository).save(guestGroup);
        assertEquals(actualGuestGroup, guestGroup);
    }


}