package org.example.carservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.carservice.model.Car;
import org.example.carservice.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/cars")
public class CarController {

    private final CarService carService;

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

}
