package customComparator;

public class Product {
	String name;
	String category;
	Double price;

	public Product(String name, String category, Double price) {
		this.name = name;
		this.category = category;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product name=" + name + ", category=" + category + ", price=" + price + "";
	}

}
