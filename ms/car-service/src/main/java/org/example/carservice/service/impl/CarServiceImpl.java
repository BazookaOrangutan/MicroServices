package org.example.carservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.carservice.dto.User;
import org.example.carservice.model.Car;
import org.example.carservice.repository.CarRepository;
import org.example.carservice.service.CarService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final RestTemplate restTemplate;

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

    @Override
    public void addUser(UUID carId, UUID userId) {

        var response = restTemplate.getForObject("http://localhost:8765/api/v1/users/" + userId, User.class);

        if (response == null) {
            throw new RuntimeException("not found");
        }

        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new RuntimeException("Not found"));
        car.setUserId(userId);
        carRepository.save(car);
    }

    @Override
    public List<Car> getUserCars(UUID id) {
        return carRepository.findAllByUserId(id);
    }
}
