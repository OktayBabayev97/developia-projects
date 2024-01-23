package task_3;

public class GenericArray<T> {
	public void firstElement(T[] arr) {
		System.out.println("First element of array: " + arr[0]);
	}

	public void lastElement(T[] arr) {
		System.out.println("Last element of array: " + arr[arr.length-1]);
	}
}
