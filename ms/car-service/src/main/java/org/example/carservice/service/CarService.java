package org.example.carservice.service;

import org.example.carservice.model.Car;

import java.util.List;
import java.util.UUID;

public interface CarService {

    Car createCar(Car car);

    Car getCar(UUID id);

    List<Car> getCars();

    Car updateCar(Car car);

    void deleteCar(UUID id);

    void addUser(UUID carId, UUID userId);

    List<Car> getUserCars(UUID id);
}
