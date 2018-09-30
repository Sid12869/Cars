package com.cars.repo.service;

import java.util.List;

import com.cars.repo.persistance.Car;



public interface CarsService {

	public List<Car> getAllCars();
	
	public Car getCar(String id);

	public void addCar(Car car);

	public void updateCar(String id, Car car);

	public void deleteCar(String id);
}