package task_2;

public class Main {

	public static void main(String[] args) {
		positiveNumber(5, -5);
	}

	public static void positiveNumber(int a, int b) {
		if (a < 0 || b < 0) {
			throw new NegativeNumberException("Cant add negative number");
		} else {
			System.out.println("Numbers are positive");
		}
	}
}
