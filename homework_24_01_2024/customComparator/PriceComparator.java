package customComparator;

import java.util.Comparator;

public class PriceComparator implements Comparator<Product> {

	@Override
	public int compare(Product p1, Product p2) {
		return p1.price.compareTo(p2.price);

	}

}
