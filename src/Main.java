
public class Main {

	public static void main(String[] args) {
		byte b = 1;
		byte bb = 2;
		short s = 3, ss = 4;
		int i = 5, ii = 6;
		long l = 7, ll = 8;
		float f = 9.1f, ff = 9.2f;
		double d = 10.0, dd = 10.1;
		char c = ' ', cc = '?';
		boolean t = true;
		boolean tt = false;

		int sum = ++b + --i;
		long difference = ll - s;
		double multiply = f * d;
		long division = ii / bb;
		int module = ii % ss;
		ii *= 5;
		boolean isTrue = bb == (ss / 2) || b != 1;
		boolean isFalse = !(s++ == 3 && --l == 6);

		System.out.println(sum);
		System.out.println(difference);
		System.out.println(multiply);
		System.out.println(division);
		System.out.println(module);
		System.out.println(ii);
		System.out.println(isTrue);
		System.out.println(isFalse);
	}

}
