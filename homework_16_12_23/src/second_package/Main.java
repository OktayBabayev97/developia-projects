package second_package;

import homework_16_12_2023.Person;

public class Main {

	public static void main(String[] args) {
		Person p = new Person();
		p.setName("Oktay");
		p.setAddress("Baku,Khatai street");
		p.setAge(26);
		System.out.println(p.getName());
		System.out.println(p.getAddress());
		System.out.println(p.getAge());
		p.setName("John");
		System.out.println(p.getName());
		Circle c = new Circle();/////// Circle classı ilə Main classı fərqli paketlərdə olduğu üçün import
								/////// edilmədiyi halda proqramı run etdikdə error verəcək.
	}

}
