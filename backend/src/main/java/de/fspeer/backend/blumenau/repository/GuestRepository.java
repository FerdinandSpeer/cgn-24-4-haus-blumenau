package de.fspeer.backend.blumenau.repository;

import de.fspeer.backend.blumenau.models.Guest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GuestRepository extends MongoRepository<Guest, String> {
}
