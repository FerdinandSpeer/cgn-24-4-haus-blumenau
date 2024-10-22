package de.fspeer.backend.models;


import java.util.List;

public record GuestGroup(
        String id,
        String groupName,
        List<GuestDTO> guestsDTO
) {

}
