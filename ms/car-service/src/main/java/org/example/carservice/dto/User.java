package org.example.carservice.dto;

import java.util.UUID;

public record User(UUID id, String name, String surname) {
}
