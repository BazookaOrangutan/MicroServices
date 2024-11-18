package org.example.carservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.carservice.model.Car;
import org.example.carservice.repository.CarRepository;
import org.example.carservice.service.CarService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;


    @Override
    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car getCar(UUID id) {
        return carRepository.findById(id).orElse(null);
    }

    @Override
    public List<Car> getCars() {
        return carRepository.findAll();
    }

    @Override
    public Car updateCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public void deleteCar(UUID id) {
        carRepository.deleteById(id);
    }
}
