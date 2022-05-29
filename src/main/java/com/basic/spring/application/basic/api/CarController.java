package com.basic.spring.application.basic.api;

import com.basic.spring.application.basic.model.Car;
import com.basic.spring.application.basic.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/car")
@RestController
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }
    @PostMapping
    public void addCar(@RequestBody Car car){
        carService.addCar(car);
    }
    @GetMapping
    public List<Car> getAllPeople(){
        return carService.getAllPeople();
    }
    @GetMapping(path = "{id}")
    public Car getCarById(@PathVariable("id") UUID id){
        return carService.getCarById(id)
                .orElse(null);
    }
    @DeleteMapping
    public void deleteCarById(@PathVariable("id") UUID id){
        carService.deleteCar(id);
    }
    @PutMapping(path = "{id}")
    public void updateCar(@PathVariable("id") UUID id, @RequestBody Car carToUpdate){
        carService.updateCar(id, carToUpdate);
    }

}
