package de.fspeer.backend.blumenau.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public record Guest(
        String id,
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
    public GuestDTO toDTO() {
        return new GuestDTO(
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
