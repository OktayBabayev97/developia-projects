package homeWork_4;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		System.out.println(addition(5, 3));
		System.out.println(subtract(11, 24));
		System.out.println(multiplication1(5.2, 10));
		System.out.println(division1(9, 4));
		Scanner scan = new Scanner(System.in);
		int operation = -1;
		while (operation != 0) {
			System.out.println(
					"Choose operation" + "\n1 for +" + "\n2 for -" + "\n3 for *" + "\n4 for /" + "\n0 for exit");
			operation = scan.nextInt();
			if (operation == 0) {
				System.out.println("Operation finished");
				break;
			} else if (operation < 0 || operation > 4) {
				System.out.println("Wrong operation selected");
			} else {
				System.out.println("Enter the first number");
				double a = scan.nextDouble();
				System.out.println("Enter the second number");
				double b = scan.nextDouble();
				if (operation == 1) {
					System.out.println(Calculator.plus(a, b));
				} else if (operation == 2) {
					System.out.println(Calculator.subtraction(a, b));
				} else if (operation == 3) {
					System.out.println(Calculator.multiplication(a, b));
				} else if (operation == 4) {
					System.out.println(Calculator.division(a, b));
				}
			}
		}
	}

	public static double plus(double a, double b) {
		return a + b;
	}

	public static double subtraction(double a, double b) {
		return a - b;
	}

	public static double multiplication(double a, double b) {
		return a * b;
	}

	public static double division(double a, double b) {
		return a / b;
	}

	//////////////////////// OVERLOAD VERSION//////////////
	public static double addition(double a, double b) {
		return a + b;
	}

	public static int addition(int a, int b) {
		return a + b;
	}

	public static double subtract(double a, double b) {
		return a - b;
	}

	public static int subtract(int a, int b) {
		return a - b;
	}

	public static double multiplication1(double a, double b) {
		return a * b;
	}

	public static int multiplication1(int a, int b) {
		return a * b;
	}

	public static double division1(double a, double b) {
		return a / b;
	}

	public static int division1(int a, int b) {
		return a / b;
	}
}
