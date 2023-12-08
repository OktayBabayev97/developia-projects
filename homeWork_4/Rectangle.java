package homeWork_4;

public class Rectangle {
	public static void main(String[] args) {
		int perimeter = perimeterRectangle(6, 4);
		int area = areaRectangle(3, 5);
		System.out.println("Rectangle perimeter: " + perimeter);
		System.out.println("Rectangle area: " + area);

	}

	public static int perimeterRectangle(int a, int b) {
		return (a + b) * 2;
	}

	public static int areaRectangle(int a, int b) {
		return a * b;
	}
}
