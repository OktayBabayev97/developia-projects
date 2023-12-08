package homeWork_4;

public class TemperatureConverter {

	public static void main(String[] args) {
		System.out.println(celsiusToFahrenheit(42));
		System.out.println(fahrenheitToCelsius(42));
	}

	public static double celsiusToFahrenheit(double temperature) {
		double result = (temperature * 1.8) + 32;
		return result;
	}

	public static double fahrenheitToCelsius(double temperature) {
		double result = (temperature - 32) / 1.8;
		return result;
	}
}
