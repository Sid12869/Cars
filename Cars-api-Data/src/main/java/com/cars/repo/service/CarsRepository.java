package com.cars.repo.service;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import com.cars.repo.persistance.Car;

@Component
public interface CarsRepository extends MongoRepository<Car, String>{
	public Car findByModel(String model);
    public List<Car> findByMake(String make);
}
