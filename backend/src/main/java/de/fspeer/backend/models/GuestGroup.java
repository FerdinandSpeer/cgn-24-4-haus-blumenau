package de.fspeer.backend.models;

import java.util.List;

public record GuestGroup(
        String groupId,
        List<Guest> guests
) {
}
