package leetcode;

/**
 * a = "11" b = "1" Return "100".
 * 
 * @author yanfeixiang
 * 
 */
public class AddBinary {
	public String addBinary(String a, String b) {
		char[] _a = a.toCharArray();
		char[] _b = b.toCharArray();
		char[] result = new char[Math.max(a.length(), b.length()) + 1];
		int add = 0;
		for (int i = 0; i < b.length() || i < a.length(); i++) {
			int a_c = 0;
			if (!(i >= a.length() || _a[a.length() - 1 - i] == '0'))
				a_c = 1;

			int b_c = 0;
			if (!(i >= b.length() || _b[b.length() - 1 - i] == '0'))
				b_c = 1;
			result[result.length - 1 - i] = (char) ('0' + (a_c + b_c + add) % 2);
			add = (a_c + b_c + add) / 2;
		}
		if (add == 1) {
			result[0] = '1';
			return new String(result);
		} else {
			result[0] = '0';
			return new String(result).substring(1);
		}

	}

	public static void main(String[] args) {
		System.out.println(new AddBinary().addBinary("0", "1"));
	}
}
