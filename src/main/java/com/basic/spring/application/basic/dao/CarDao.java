package com.basic.spring.application.basic.dao;

import com.basic.spring.application.basic.model.Car;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CarDao {

    abstract int insertCar(UUID id, Car car);

    default int insertCar(Car car){
        UUID id = UUID.randomUUID();
        return insertCar(id,car);
    }
    List<Car> allCars();

    Optional<Car> selectCarByID(UUID id);

    abstract int deleteCarById(UUID id);

    abstract int updateCarById(UUID id, Car car);

}
