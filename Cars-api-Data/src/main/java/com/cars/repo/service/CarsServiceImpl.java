package com.cars.repo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cars.repo.persistance.Car;

@Service
public class CarsServiceImpl implements CarsService {
	private List<Car> cars = new ArrayList<>(Arrays.asList(new Car("BMWM5", "BMW", "M5", 5, 155, 89705.00),
			new Car("LFA", "Lexus", "LFA", 5, 202, 375000.00),
			new Car("RRE", "Range Rover", "evoque", 6, 135, 39000.00)));

	@Autowired
	private CarsRepository carsRepo;

	public List<Car> getAllCars() {
		return carsRepo.findAll();
	}

	public Car getCar(String id) {
		return carsRepo.findAll().stream().filter(i -> i.getId().equals(id)).findFirst().get();
	}

	public void addCar(Car car) {
		carsRepo.save(car);
	}

	public void updateCar(String id, Car car) {
		Optional<Car> oldCar = carsRepo.findById(id);
		if (oldCar.isPresent()) {
			carsRepo.delete(oldCar.get());
			carsRepo.save(car);
		}

	}

	public void deleteCar(String id) {
		Optional<Car> oldCar = carsRepo.findById(id);
		if(oldCar.isPresent()) {
			carsRepo.delete(oldCar.get());
		}
	}

}