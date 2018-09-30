package com.cars.repo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cars.repo.persistance.Car;
import com.cars.repo.service.CarsService;

@RestController
public class CarsController {
	@Autowired
	private CarsService carService;
	
	@GetMapping("/cars")
	public List<Car> getAllCars() {
		return carService.getAllCars();
	}
	
	@RequestMapping("/cars/{id}")
	public Car getCar(@PathVariable String id) {
		return carService.getCar(id);
	}
	
	@PostMapping("/cars")
	public void addCar(@RequestBody Car car) {
		carService.addCar(car);
	}
	
	@PutMapping("/cars/{id}")
	public void updateCar(@PathVariable String id , @RequestBody Car car) {
		carService.updateCar(id , car);
	}
	
	@DeleteMapping("/cars/{id}")
	public void deleteCar(@PathVariable String id) {
		carService.deleteCar(id);
	}
}
