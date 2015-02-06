package leetcode;

/**
 * What a fuck problem. "0" => true " 0.1 " => true "abc" => false "1 a" =>
 * false "2e10" => true
 * 
 * @author yanfeixiang
 * 
 */
public class ValidNumber {
	public boolean isNumber(String s) {
		// System.out.println(s);
		s = s.trim();
		if (s.length() == 0)
			return false;

		if (s.charAt(0) == '-' || s.charAt(0) == '+')
			s = s.substring(1);

		if ((s.length() == 1 && s.endsWith(".")) || s.endsWith("e")
				|| s.startsWith("e"))
			return false;

		int i = 0;
		// System.out.println("@@@@");
		while (i < s.length() && s.charAt(i) == '0')
			i++;
		if (i == s.length())
			return true;
		// System.out.println("####");
		int dotCount = 0;
		boolean e = false;
		char[] c = s.toCharArray();
		for (; i < c.length; i++) {

			// System.out.println(c[i]);
			if (c[i] == '.') {
				if (dotCount == 1 || (i > 0 && c[i - 1] == 'e'))
					return false;
				if (e && i == c.length - 1)
					return false;

				// if (i == 0)
				// return false;

				dotCount = 1;
			} else if ('0' <= c[i] && '9' >= c[i]) {
				// if (i == 1 && c[0] == '0')
				// return false;
				// System.out.println("%%%%%%%%");
				if (e && dotCount == 1 && c[i] != '0')
					return false;
				// System.out.println("$$$$$$$");
			} else if (c[i] == 'e') {
				// System.out.println("1111");
				if (e)
					return false;
				// System.out.println("2222");
				if (i == 0 || (i == 1 && c[i - 1] == '.'))
					return false;

				dotCount = 0;
				e = true;

			} else if (c[i] == '+' || c[i] == '-') {
				if (i == 0 || c[i - 1] != 'e')
					return false;
				if (e && i == c.length - 1)
					return false;

			} else {
				return false;
			}
		}
		return true;
	}
}
