package com.cars.repo.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.cars.repo.persistance.Car;
import com.cars.repo.service.CarsService;

public class CarsControllerTest {

	@Mock
	private CarsService carsService;

	private Car car;

	@InjectMocks
	private CarsController carsController = new CarsController();

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetAllCars() {

		List<Car> expected = buildListOfCars();

		when(carsService.getAllCars()).thenReturn(buildListOfCars());

		List<Car> actual = carsController.getAllCars();

		assert (expected.size() == actual.size());
		for (int i = 0; i < actual.size(); i++) {
			assertThat(expected.get(i)).isEqualToComparingFieldByFieldRecursively(actual.get(i));
		}
	}

	@Test
	public void testUpdateCar() {
		Car car = new Car();

		carsController.updateCar("BMWM32", car);

		Mockito.verify(carsService, Mockito.times(1)).updateCar("BMWM32", car);
	}

	@Test
	public void testDeleteCar() {
		carsController.deleteCar("BMWM32");

		Mockito.verify(carsService, Mockito.times(1)).deleteCar("BMWM32");
	}

	@Test
	public void testAddCar() {
		Car car = new Car();

		carsController.addCar(car);

		Mockito.verify(carsService, Mockito.times(1)).addCar(car);
	}

	@Test
	public void testGetCars() {
		Car expected = buildCar();

		when(carsService.getCar("BMWM32")).thenReturn(buildCar());

		Car actual = carsController.getCar("BMWM32");

		assertThat(expected).isEqualToComparingFieldByFieldRecursively(actual);

	}

	private Car buildCar() {
		car = new Car();

		car.setId("BMWM32");
		car.setMake("BMW");
		car.setModel("M5");
		car.setEngineSize(6);
		car.setTopSpeed(170);
		car.setAvgPrice(49999.99);

		return car;
	}

	private List<Car> buildListOfCars() {
		List<Car> carsList = new ArrayList<Car>();

		carsList.add(buildCar());
		return carsList;
	}

}
