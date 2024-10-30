package de.fspeer.backend.models;


import org.springframework.data.annotation.Id;

import java.util.List;

public record GuestGroup(
        @Id
        String groupId,
        List<Guest> guests

) {
}
