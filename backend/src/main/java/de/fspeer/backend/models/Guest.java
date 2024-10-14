package de.fspeer.backend.models;


import java.util.Date;


public record Guest(
        String id,
        String firstName,
        String lastName,
        Date birthDate,
        String nationality,
        String street,
        String city,
        int zip,
        String email,
        int phoneNumber,
        String travelDocumentNumber
) {
    public Guest(String id, String firstName, String lastName, Date birthDate, String nationality, String street, String city, int zip, String email, int phoneNumber, String travelDocumentNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.nationality = nationality;
        this.street = street;
        this.city = city;
        this.zip = zip;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.travelDocumentNumber = travelDocumentNumber;
    }
}
