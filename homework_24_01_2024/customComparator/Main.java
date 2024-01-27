package customComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Product p1 = new Product("Nokia", "Mobile phones", 149.99);
		Product p2 = new Product("Asus", "Laptops", 999.99);
		Product p3 = new Product("Whey Protein", "Suplements", 79.99);
		List<Product> list = new ArrayList<>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		Collections.sort(list, new PriceComparator());
		for (Product products : list) {
			System.out.println(products);
		}
	}

}
