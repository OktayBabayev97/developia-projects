package task_1;

public class Rectangle extends Shape {
	double width;
	double length;

	public Rectangle(double width, double length) {
		this.width = width;
		this.length = length;
	}

	@Override
	public void calculateArea() {
		area = width * length;
		System.out.println("Rectangle area: " + area);

	}
}
