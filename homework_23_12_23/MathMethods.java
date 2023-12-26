package homework_23_12_23;

public class MathMethods {

	public static void main(String[] args) {
		double a = 5.2;
		double b = 6.8;
		int i = 9;
		System.out.println("abs(): " + Math.abs(a));
		System.out.println("max(): " + Math.max(a, b));
		System.out.println("min(): " + Math.min(a, i));
		System.out.println("round(): " + Math.round(b));
		System.out.println("sqrt(): " + Math.sqrt(i));
		System.out.println("cbrt(): " + Math.cbrt(i));
		System.out.println("pow(): " + Math.pow(9, 3));
		System.out.println("ceil(): " + Math.ceil(a));
		System.out.println("floor(): " + Math.floor(b));
		System.out.println("random(): " + Math.round(Math.random() * 100));
		System.out.println("toDegrees(): " + Math.toDegrees(a));
		System.out.println("toRadians(): " + Math.toRadians(b));
	}

}
