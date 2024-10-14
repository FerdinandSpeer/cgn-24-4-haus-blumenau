package de.fspeer.backend.service;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class IdService {
        public static String generateId() {
        return UUID.randomUUID().toString();
    }
    }

