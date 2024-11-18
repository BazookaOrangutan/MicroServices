package org.example.carservice.repository;

import org.example.carservice.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CarRepository extends JpaRepository<Car, UUID> {
    List<Car> findAllByUserId(UUID userId);
}
