package task_1;

public class Circle extends Shape {
	public static final double Pi = 3.14;
	public double radius;

	public Circle(double radius) {
		this.radius = radius;
	}

	@Override
	public void calculateArea() {
		area = Pi * radius * radius;
		System.out.println("Circle area: " + Math.round(area));
	}
}
