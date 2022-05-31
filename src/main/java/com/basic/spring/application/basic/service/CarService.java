package com.basic.spring.application.basic.service;

import com.basic.spring.application.basic.dao.CarDao;
import com.basic.spring.application.basic.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CarService {

    private final CarDao carDao;

    @Autowired
    public CarService(@Qualifier("postgres") CarDao carDao) {
        this.carDao = carDao;
    }

     public int addCar(Car car){
        return carDao.insertCar(car);
     }
     public List<Car> getAllPeople(){
        return carDao.allCars();
     }
     public Optional<Car> getCarById(UUID id){
        return carDao.selectCarByID(id);
     }
     public int deleteCar(UUID id){
        return carDao.deleteCarById(id);
     }
     public int updateCar(UUID id, Car newCar){
        return carDao.updateCarById(id, newCar);
     }
}
