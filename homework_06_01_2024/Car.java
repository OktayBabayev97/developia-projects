package homework_06_01_2024;

public class Car extends Vehicle {
	String fuelType;
	double weight;
	String transmission;

	public Car(String fuelType, double weight, String transmisson, String make, String model, int year) {
		super(make, model, year);
		this.fuelType = fuelType;
		this.weight = weight;
		this.transmission = transmisson;
	}

	@Override
	public void displayDetails() {
		super.displayDetails();
		System.out.println("Fuel type: " + fuelType + "\nWeight: " + weight + " kg\nTransmission: " + transmission);
	}
}
