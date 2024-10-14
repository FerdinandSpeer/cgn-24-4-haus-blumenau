package de.fspeer.backend.service;

public class IdService {
    public String generateId(){
        return java.util.UUID.randomUUID().toString();
    }
}
