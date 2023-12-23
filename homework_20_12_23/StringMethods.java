package homework_20_12_23;

public class StringMethods {

	public static void main(String[] args) {
		String firstWord = "Java";
		String secondWord = " developer";
		System.out.println("length(): " + firstWord.length());
		System.out.println("concat(): " + firstWord.concat(secondWord));
		System.out.println("charAt(): " + firstWord.charAt(3));
		System.out.println("endsWith(): " + secondWord.endsWith("r"));
		System.out.println("equals(): " + firstWord.equals(secondWord));
		System.out.println("indexOf(): " + secondWord.indexOf("p"));
		System.out.println("isBlank(): " + secondWord.isBlank());
		System.out.println("isEmpty(): " + firstWord.isEmpty());
		System.out.println("replace(): " + firstWord.replaceAll("a", "e"));
		String[] str = secondWord.split("e");
		for (String s : str) {
			System.out.println(s);
		}
		System.out.println("startsWith(): " + secondWord.startsWith(" dev"));
		System.out.println("substring(): " + secondWord.substring(3, 8));
		System.out.println("toLowerCase(): " + firstWord.toLowerCase());
		System.out.println("toUpperCase(): " + secondWord.toUpperCase());
		System.out.println("contains(): " + secondWord.contains("elo"));
		System.out.println("trim():" + secondWord.trim());
		System.out.println("compareToIgnoreCase(): " + firstWord.compareToIgnoreCase("JaVa"));
		System.out.println("compareTo(): " + secondWord.compareTo(secondWord));
		System.out.println("regionMatches(): " + firstWord.regionMatches(0, "jave", 0, 4));

		String number = "46-528-35";
		String pattern = "[0-9]{2}-[0-9]{3}-[0-9]{2}";
		System.out.println("matches(): " + number.matches(pattern));
		System.out.println("concat(): " + firstWord.concat(secondWord));
		char[] charArray = { 'h', 'e', 'l', 'l', 'o' };
		System.out.println("copyValueOf(): " + String.copyValueOf(charArray));
	}

}
