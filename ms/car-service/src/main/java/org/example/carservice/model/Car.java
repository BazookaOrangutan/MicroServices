package org.example.carservice.model;

import jakarta.persistence.*;
import lombok.Data;
import org.apache.catalina.User;

import java.util.UUID;

@Entity
@Data
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String color;
    private String model;
    private UUID userId;
}
