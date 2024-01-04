package homework_27_12_23;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		lightColor(TrafficLight.RED);
		System.out.println(calculate(5, 15, Operation.ADDITION));
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter a number range from 1 to 7");
		int number = scan.nextInt();
		switch (number) {
		case 1:
			System.out.println(DayOfWeek.MONDAY);
			break;
		case 2:
			System.out.println(DayOfWeek.TUESDAY);
			break;
		case 3:
			System.out.println(DayOfWeek.WEDNSDAY);
			break;
		case 4:
			System.out.println(DayOfWeek.THURSDAY);
			break;
		case 5:
			System.out.println(DayOfWeek.FRIDAY);
			break;
		case 6:
			System.out.println(DayOfWeek.SATURDAY);
			break;
		case 7:
			System.out.println(DayOfWeek.SUNDAY);
			break;
		default:
			System.err.println("Worng number entered!");

		}

	}

	public static void lightColor(TrafficLight color) {
		switch (color) {
		case RED:
			System.out.println(TrafficLight.YELLOW);
			break;
		case YELLOW:
			System.out.println(TrafficLight.GREEN);
			break;
		case GREEN:
			System.out.println(TrafficLight.RED);
			break;
		}

	}

	public static double calculate(double a, double b, Operation operation) {
		double result = 0;
		switch (operation) {
		case ADDITION:
			result = a + b;
			break;
		case SUBTRACTION:
			result = a - b;
			break;
		case MULTIPLICATION:
			result = a + b;
			break;
		case DIVISION:
			result = a + b;
			break;
		default:
			System.err.println("Wrong operation selected");
		}
		return result;
	}
}
