package com.cars.repo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.cars.repo.persistance.Car;

public class CarsServiceImplTest {
	@Mock
	private CarsRepository carsRepo;

	private Car car;

	@InjectMocks
	private CarsServiceImpl carsService = new CarsServiceImpl();

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetAllCars() {

		List<Car> expected = buildListOfCars();

		when(carsRepo.findAll()).thenReturn(buildListOfCars());

		List<Car> actual = carsService.getAllCars();

		assert (expected.size() == actual.size());
		for (int i = 0; i < actual.size(); i++) {
			assertThat(expected.get(i)).isEqualToComparingFieldByFieldRecursively(actual.get(i));
		}
	}

	@Test
	public void testGetCar() {

		Car expected = buildCar();

		when(carsRepo.findAll()).thenReturn(buildListOfCars());

		Car actual = carsService.getCar("BMWM32");
		
		assertThat(expected).isEqualToComparingFieldByFieldRecursively(actual);
	}
	
	@Test
	public void testAddCar() {
		Car car = new Car();

		carsService.addCar(car);

		Mockito.verify(carsRepo, Mockito.times(1)).save(car);
	}
	
	@Test
	public void testUpdateCar() {
		Car car = new Car();
		
		Optional<Car> oldCar = Optional.of(car);
		
		when(carsRepo.findById("BMW32")).thenReturn(oldCar);

		
		carsService.updateCar("BMW32", car);
		
		Mockito.verify(carsRepo, Mockito.times(1)).delete(car);
		Mockito.verify(carsRepo, Mockito.times(1)).save(car);
	}
	
	@Test
	public void testDeleteCar() {
		Car car = new Car();
		
		Optional<Car> oldCar = Optional.of(car);
		
		when(carsRepo.findById("BMW32")).thenReturn(oldCar);

		carsService.deleteCar("BMW32");
		
		Mockito.verify(carsRepo, Mockito.times(1)).delete(car);
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
