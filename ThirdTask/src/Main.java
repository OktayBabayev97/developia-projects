import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter number");
		int number = scan.nextInt();
		System.out.println("Please enter exponent");
		int exponent = scan.nextInt();
		int result = 1;
		System.out.print(number + "^" + exponent + "=");
		while (exponent > 0) {
			result *= number;
			--exponent;
		}
		System.out.println(result);
	}

}
