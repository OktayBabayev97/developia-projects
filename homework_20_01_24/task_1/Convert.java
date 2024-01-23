package task_1;

import java.util.Scanner;

public class Convert {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number");
		String value = scan.nextLine();
		try {
			System.out.println(Integer.parseInt(value));
		} catch (NumberFormatException e) {
			System.out.println("Wrong value entered.Please enter only number");
		}
	}
}
