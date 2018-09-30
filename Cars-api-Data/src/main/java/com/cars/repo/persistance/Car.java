package com.cars.repo.persistance;

import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

import org.springframework.data.annotation.Id;

public class Car {
	@Id
	private String id;
	private String make;
	private String model;
	private int engineSize;
	private int topSpeed;
	private Double avgPrice;

	public Car() {

	}

	public Car(String id, String make, String model, int engineSize, int topSpeed, Double avgPrice) {
		super();
		this.id = id;
		this.make = make;
		this.model = model;
		this.engineSize = engineSize;
		this.topSpeed = topSpeed;
		this.avgPrice = avgPrice;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getEngineSize() {
		return engineSize;
	}

	public void setEngineSize(int engineSize) {
		this.engineSize = engineSize;
	}

	public int getTopSpeed() {
		return topSpeed;
	}

	public void setTopSpeed(int topSpeed) {
		this.topSpeed = topSpeed;
	}

	public Double getAvgPrice() {
		return avgPrice;
	}

	public void setAvgPrice(Double avgPrice) {
		this.avgPrice = avgPrice;
	}

	@Override
	public String toString() {
		return "This car is a " + make + " " + model + " with a top speed of " + topSpeed + "and a price of "
				+ avgPrice;

	}

}
