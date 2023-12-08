package homeWork_4;

import java.util.Scanner;

public class MultiplicationTable {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number");
		int number = scan.nextInt();
		multiplication(number);
	}

	public static void multiplication(int a) {
		int i = 1;
		while (i <= 10) {
			System.out.println(i + " * " + a + "= " + (i * a));
			i++;
		}
	}
}
