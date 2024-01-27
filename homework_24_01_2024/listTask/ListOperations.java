package listTask;

import java.util.ArrayList;
import java.util.List;

public class ListOperations {

	public static void main(String[] args) {
		List<Integer> luckyNumbers = new ArrayList<Integer>();
		luckyNumbers.add(7);
		luckyNumbers.add(9);
		luckyNumbers.add(8);
		luckyNumbers.add(17);
		System.out.println(luckyNumbers);
		System.out.println(luckyNumbers.get(1));
		luckyNumbers.remove(3);
		System.out.println(luckyNumbers);
		luckyNumbers.set(2, 5);
		System.out.println(luckyNumbers);
	}

}
