package homework_23_12_23;

public class StringBuilderTasks {

	public static void main(String[] args) {
		StringBuilder firstString = new StringBuilder("Hello,");
		StringBuilder secondString = new StringBuilder("good morning");
		concat("Hello", ",good ", "morning");
		reverse("See you again");
		customReverse(firstString);
		////////////////// StringBuilder methods////////////////////
		System.out.println("append(): " + firstString.append(secondString));
		System.out.println("insert(): " + firstString.insert(5, secondString));
		System.out.println("replace(): " + firstString.replace(5, 12, "great"));
		System.out.println("delete(): " + firstString.delete(5, 12));
		System.out.println("reverse(): " + firstString.reverse());
		System.out.println("capacity(): " + firstString.capacity());
		int minimumCapacity = 28;
		firstString.ensureCapacity(minimumCapacity);
		System.out.println("ensureCapacity(): " + firstString.capacity());
		System.out.println("charAt(): " + firstString.charAt(5));
		System.out.println("length(): " + firstString.length());
		System.out.println("substring(): " + firstString.substring(5, 12));
	}

	public static void concat(String first, String second, String third) {
		StringBuilder s = new StringBuilder();
		s = s.append(first).append(second).append(third);
		System.out.println(s);
	}

	public static void reverse(String str) {
		StringBuilder s = new StringBuilder(str);
		s.toString();
		StringBuilder sReverse = s.reverse();
		System.out.println(sReverse.toString());
	}

	public static void customReverse(StringBuilder str) {
		StringBuilder s = new StringBuilder(str);
		StringBuilder reverseStr = new StringBuilder();
		for (int i = str.length() - 1; i >= 0; i--) {

			reverseStr.append(s.charAt(i));
		}
		System.out.println(reverseStr);
	}

}
