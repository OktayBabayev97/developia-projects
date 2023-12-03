import java.util.Scanner;

public class Factorial {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int number;
		int result = 1;
		do {
			System.out.println("Please enter zero or a number greater than zero");
			number = scan.nextInt();
			if (number > 0) {
				for (int i = 1; i <= number; i++) {
					result *= i;
				}
				System.out.println(number + "!= " + result);
				break;

			} else if (number == 0) {
				System.out.println(number + "!=" + result);
				break;
			}
		} while (number <= 0);
	}
}
