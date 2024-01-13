package task_2;

import java.util.Scanner;

public class RectangleDrawer implements Drawable {
	Scanner scan = new Scanner(System.in);

	@Override
	public void draw() {
		System.out.println("Enter length of rectamgle");
		int length = scan.nextInt();
		System.out.println("Enter width of rectamgle");
		int width = scan.nextInt();
		for (int w = 1; w <= width; w++) {
			for (int l = 0; l <= length; l++) {
				System.out.print("#");
			}
			System.out.println();
		}
	}

}
