package org.example.carservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.carservice.dto.User;
import org.example.carservice.model.Car;
import org.example.carservice.service.CarService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/cars")
public class CarController {

    private final CarService carService;
    private final RestTemplate restTemplate;

    @PostMapping
    public Car createCar(@RequestBody Car car){
        return carService.createCar(car);
    }

    @GetMapping("{id}")
    public Car getCar(@PathVariable UUID id){
        return carService.getCar(id);
    }

    @GetMapping
    public List<Car> getCars(){
        return carService.getCars();
    }

    @PutMapping
    public Car updateCar(@RequestBody Car car){
        return carService.updateCar(car);
    }

    @DeleteMapping("{id}")
    public void deleteCar(@PathVariable UUID id){
        carService.deleteCar(id);
    }

    @PostMapping("{carId}/users/{userId}")
    public void addUser(@PathVariable UUID carId, @PathVariable UUID userId){
        carService.addUser(carId, userId);
    }

    @GetMapping("users/{id}")
    public List<Car> getCarsByUserId(@PathVariable UUID id){
        return carService.getUserCars(id);
    }
}
