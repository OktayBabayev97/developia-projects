package homework_06_01_2024;

public class Vehicle {
	String make;
	String model;
	int year;

	public Vehicle(String make, String model, int year) {
		this.make = make;
		this.model = model;
		this.year = year;
	}

	public void displayDetails() {
		System.out.println("Car make: " + make + "\nCar model: " + model + "\nYear: " + year);
	}
}
