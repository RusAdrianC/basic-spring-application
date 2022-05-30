package com.basic.spring.application.basic.dao;

import com.basic.spring.application.basic.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class CarDataAccessService implements CarDao{
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CarDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertCar(UUID id, Car car) {
        return 0;
    }

    @Override
    public List<Car> allCars() {
        String sql = "SELECT id, name FROM car;";
        List<Car> people = jdbcTemplate.query(sql,(resultSet, i)->{
            UUID id = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            return new Car(id,name);
        } );
        return people;
    }

    @Override
    public Optional<Car> selectCarByID(UUID id) {
        final String sql = "SELECT id, name FROM person WHERE id = ?";
        Car car = jdbcTemplate.queryForObject(sql, new Object[]{id},(resultSet, i)->{
            UUID carID = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            return new Car(carID,name);
        } );
        return Optional.ofNullable(car);
    }

    @Override
    public int deleteCarById(UUID id) {
        return 0;
    }

    @Override
    public int updateCarById(UUID id, Car car) {
        return 0;
    }
}
