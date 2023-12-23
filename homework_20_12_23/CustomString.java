package homework_20_12_23;

public class CustomString {
	public static void main(String[] args) {
		String text = new String("Have a nice day!");
		String word = "Thanks";
		CustomString s = new CustomString();

		System.out.println(s.customLength(word));
		s.customCharAt(text, 4);
		s.customToCharArray(word);

		String checkIsBlank = "     ";
		System.out.println(s.customIsBlank(checkIsBlank));

		String checkIsEmpty = "";
		System.out.println(s.customIsEmpty(checkIsEmpty));

		System.out.println("is contains?-> " + s.customContains(word, "k"));
		System.out.println("valueOf: " + s.customValueOf(false));

		char[] arr = { 'j', 'a', 'v', 'a' };
		System.out.println(s.customValueOf(arr));
	}

	public int customLength(String s) {
		char[] symbols = s.toCharArray();
		int count = 0;
		for (int i = 0; count < symbols.length; i++) {
			count++;
		}
		return count;
	}

	public void customCharAt(String s, int index) {
		char[] symbols = s.toCharArray();
		for (int i = 0; i < symbols.length; i++) {
			if (i == index) {
				System.out.println(symbols[i]);
				break;
			} else if (index >= symbols.length) {
				System.err.println(
						"Exception in thread \"main\": " + index + " out of bounds for length " + symbols.length);
				break;
			}
		}
	}

	public char[] customToCharArray(String s) {
		char[] c = new char[s.length()];
		for (int i = 0; i < c.length; i++) {
			c[i] = s.charAt(i);
			System.out.print(c[i]);
		}
		System.out.println();
		return c;
	}

	public boolean customIsBlank(String s) {
		boolean check = false;
		if (s.trim().equals(""))
			check = true;
		return check;
	}

	public boolean customIsEmpty(String s) {
		boolean check = false;
		if (s.equals(""))
			check = true;
		return check;
	}

	public boolean customContains(String text, String checkPart) {
		char[] t = text.toCharArray();
		char[] p = checkPart.toCharArray();
		boolean check = false;
		for (int i = 0; i < t.length; i++) {
			for (int k = 0; k < p.length; k++) {
				if (t[i] == p[k]) {
					check = true;
				}
			}
		}
		return check;
	}

	public String customValueOf(boolean b) {
		return "" + b;
	}

	public String customValueOf(double d) {
		return "" + d;
	}

	public String customValueOf(int i) {
		return "" + i;
	}

	public String customValueOf(char[] c) {
		String s = "";
		for (int i = 0; i < c.length; i++) {
			s += c[i];
		}
		return s;
	}
}
