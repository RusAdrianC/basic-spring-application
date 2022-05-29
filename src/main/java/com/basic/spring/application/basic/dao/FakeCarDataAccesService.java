package com.basic.spring.application.basic.dao;

import com.basic.spring.application.basic.model.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakeCarDataAccesService implements CarDao{

    private static List<Car> fakeDB = new ArrayList<>();

    @Override
    public int insertCar(UUID id, Car car) {
        fakeDB.add(new Car( id, car.getName()));
        return 1;
    }

    @Override
    public List<Car> allCars() {
        return fakeDB;
    }

    @Override
    public Optional<Car> selectCarByID(UUID id) {
        return fakeDB.stream()
                        .filter(car ->car.getId().equals(id))
                        .findFirst();
    }

    @Override
    public int deleteCarById(UUID id) {
        Optional<Car> carMaybe = selectCarByID(id);

        if(carMaybe.isEmpty()){
            return 0;
        }
        fakeDB.remove(carMaybe.get());
        return 1;
    }

    @Override
    public int updateCarById(UUID id, Car car) {
       return selectCarByID(id)
               .map(c -> {
                   int indexOfCarToDelete = fakeDB.indexOf(c);
                   if(indexOfCarToDelete >= 0 ){
                       fakeDB.set(indexOfCarToDelete,new Car(car.getId(),car.getName()));
                       return 1;
                   }
                   return 0;
               })
               .orElse(0);
    }
}
