package de.fspeer.backend.models;


public record GuestDTO (
        String groupName,
        String arrivalDate,
        String departureDate,
        String firstName,
        String lastName,
        String birthDate,
        String nationality,
        String street,
        String city,
        int zip,
        String email,
        String phoneNumber,
        String travelDocumentNumber
) {

    public Guest fromDTO(String guestId) {
        return new Guest(guestId,
                this.groupName(),
                this.arrivalDate(),
                this.departureDate(),
                this.firstName(),
                this.lastName(),
                this.birthDate(),
                this.nationality(),
                this.street(),
                this.city(),
                this.zip(),
                this.email(),
                this.phoneNumber(),
                this.travelDocumentNumber()
        );
    }
}

