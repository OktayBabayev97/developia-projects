package task_2;

import java.util.Scanner;

public class CircleDrawer implements Drawable {
	Scanner scan = new Scanner(System.in);
	int radius;

	@Override
	public void draw() {
		System.out.println("Enter radisus of circle");
		radius = scan.nextInt();
		int point, xCoord, yCoord;
		for (int x = 0; x <= radius * 2; x++) {
			for (int y = 0; y <= radius * 2; y++) {
				xCoord = radius - x;
				yCoord = radius - y;
				point = xCoord * xCoord + yCoord * yCoord;
				if (point <= radius * radius + 1) {
					System.out.print("* ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}

}
