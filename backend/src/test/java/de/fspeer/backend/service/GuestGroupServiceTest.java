package de.fspeer.backend.service;

import de.fspeer.backend.models.Guest;
import de.fspeer.backend.models.GuestGroup;
import de.fspeer.backend.repository.GuestGroupRepository;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class GuestGroupServiceTest {

    private final GuestGroupRepository guestGroupRepository = mock(GuestGroupRepository.class);
    private final IdService idService = mock(IdService.class);

    @Test
    void createGuestGroup() {
        List<Guest> guests = List.of(new Guest("1", "test", "test", "test", "test", "test", "test", 1, "test", "test", "test"));
        GuestGroup guestGroup = new GuestGroup("1", guests);
        when(guestGroupRepository.save(guestGroup)).thenReturn(guestGroup);
        when(idService.generateId()).thenReturn("1");

        GuestGroupService guestGroupService = new GuestGroupService(guestGroupRepository, idService);

        GuestGroup actualGuestGroup = guestGroupService.createGuestGroup(guests);
        verify(guestGroupRepository).save(guestGroup);
        assertEquals(actualGuestGroup, guestGroup);
    }

    @Test
    void findByGroupId() {
        List<Guest> guests = List.of(new Guest("1", "test", "test", "test", "test", "test", "test", 1, "test", "test", "test"));
        GuestGroup guestGroup = new GuestGroup("2", guests);
        when(guestGroupRepository.findById("2")).thenReturn(Optional.of(guestGroup));

        GuestGroupService guestGroupService = new GuestGroupService(guestGroupRepository, idService);

        GuestGroup actualGuestGroup = guestGroupService.findByGroupId("2").orElseThrow();
        verify(guestGroupRepository).findById("2");
        assertEquals(actualGuestGroup.guests(), guestGroup.guests());    }

@Test
void findByGroupId_groupNotFound() {
    when(guestGroupRepository.findById("1")).thenReturn(Optional.empty());

    GuestGroupService guestGroupService = new GuestGroupService(guestGroupRepository, idService);

    Optional<GuestGroup> result = guestGroupService.findByGroupId("1");
    assertTrue(result.isEmpty());
    verify(guestGroupRepository).findById("1");
}

}