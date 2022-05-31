package com.basic.spring.application.basic.dao;

import com.basic.spring.application.basic.model.Car;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CarDao {

    int insertCar(UUID id, Car car);

    default int insertCar(Car car){
        UUID id = UUID.randomUUID();
        return insertCar(id,car);
    }
    List<Car> allCars();

    Optional<Car> selectCarByID(UUID id);

    int deleteCarById(UUID id);

    abstract int updateCarById(UUID id, Car car);

}
