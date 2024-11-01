package de.fspeer.backend.models;


import lombok.With;
import org.springframework.data.annotation.Id;

import java.util.List;

@With
public record GuestGroup(
        @Id
        String groupId,
        List<Guest> guests

) {
}
