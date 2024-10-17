package de.fspeer.backend.repository;

import de.fspeer.backend.models.GuestGroup;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GuestGroupRepository extends MongoRepository<GuestGroup, String> {
}
