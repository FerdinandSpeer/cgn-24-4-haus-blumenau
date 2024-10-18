package de.fspeer.backend.service;

import de.fspeer.backend.models.GuestDTO;
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
    void createGuestGroup() {
        List<GuestDTO> guestsDTO = List.of(new GuestDTO("test", "test", "test", "test", "test", "test", 1, "test", "test", "test"));
        GuestGroup guestGroup = new GuestGroup("1", guestsDTO);
        when(guestGroupRepository.save(guestGroup)).thenReturn(guestGroup);
        when(idService.generateId()).thenReturn("1");

        GuestGroupService guestGroupService = new GuestGroupService(guestGroupRepository, idService);

        GuestGroup actualGuestGroup = guestGroupService.createGuestGroup(guestsDTO);
        verify(guestGroupRepository).save(guestGroup);
        assertEquals(actualGuestGroup, guestGroup);
    }

    @Test
    void findByGroupId() {
        List<GuestDTO> guestsDTO = List.of(new GuestDTO("test", "test", "test", "test", "test", "test", 1, "test", "test", "test"));
        GuestGroup guestGroup = new GuestGroup("2", guestsDTO);
        when(guestGroupRepository.findById("2")).thenReturn(Optional.of(guestGroup));

        GuestGroupService guestGroupService = new GuestGroupService(guestGroupRepository, idService);

        GuestGroup actualGuestGroup = guestGroupService.findByGroupId("2");
        verify(guestGroupRepository).findById("2");
        assertEquals(actualGuestGroup.guestsDTO(), guestGroup.guestsDTO());    }

@Test
void findByGroupId_groupNotFound() {
    when(guestGroupRepository.findById("1")).thenReturn(Optional.empty());

    GuestGroupService guestGroupService = new GuestGroupService(guestGroupRepository, idService);

    assertThrows(NoSuchElementException.class, () -> guestGroupService.findByGroupId("1"));
}

}