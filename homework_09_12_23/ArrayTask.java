package homework_09_12_23;

public class ArrayTask {

	public static void main(String[] args) {
		ArrayTask a = new ArrayTask();
		System.out.println(a.printElementAtIndex(3));
		a.printArrayUsingForLoop(a.numbers);
		a.printArrayUsingForeach(a.numbers);
		a.doubleArrayValues(a.numbers);
		System.out.println("Sum of array elemnts: " + a.calculateArraySum(a.numbers));
		System.out.println("Boolean answer: " + a.searchArray(14));
	}

	int[] numbers = new int[] { 5, 3, 8, 7, 42 };

	public int printElementAtIndex(int index) {
		System.out.print("The element at index " + index + " is ");
		return numbers[index];
	}

	public void printArrayUsingForLoop(int[] arr) {
		System.out.print("Printed of array elements with for loop: ");
		for (int i = 0; i <= arr.length - 1; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println();
	}

	public void printArrayUsingForeach(int[] arr) {
		System.out.print("Printed of array elements wtih foreach: ");
		for (int elements : arr) {
			System.out.print(elements + ", ");
		}
		System.out.println();
	}

	public void doubleArrayValues(int[] arr) {
		for (int i = 0; i <= arr.length - 1; i++) {
			numbers[i] = numbers[i] * 2;
		}
		System.out.print("The value of all the numbers in the array is changed to a multiple of itself: ");
		for (int doubleArrays : numbers) {
			System.out.print(doubleArrays + ", ");
		}
		System.out.println();
	}

	public int calculateArraySum(int[] arr) {
		int sumOfArrayElements = 0;
		for (int i = 0; i <= arr.length - 1; i++) {
			sumOfArrayElements += arr[i];
		}
		return sumOfArrayElements;
	}

	public boolean searchArray(int number) {
		boolean check = false;
		for (int i = 0; i <= numbers.length - 1; i++) {
			if (number == numbers[i]) {
				check = true;
				break;
			}
		}
		return check;
	}
}
