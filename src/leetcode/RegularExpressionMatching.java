package leetcode;

/*
 * Some examples:
 isMatch("aa","a") ¡ú false
 isMatch("aa","aa") ¡ú true
 isMatch("aaa","aa") ¡ú false
 isMatch("aa", "a*") ¡ú true
 isMatch("aa", ".*") ¡ú true
 isMatch("ab", ".*") ¡ú true
 isMatch("aab", "c*a*b") ¡ú true
 */
public class RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
		int count = lessChar(p);
		return isMatch(s, p, count);

	}

	public boolean isMatch(String s, String p, int count) {
		// System.out.println("s: " + s + ",p: " + p);
		if (s.equals("")) {
			return count == 0;

		} else if (p.equals(""))
			return false;

		if (s.length() < count) {
			// System.out.println("cut");
			return false;
		}

		String matched = s.substring(0, 1);
		String matcher = p.substring(0, 1);

		if (p.length() >= 2 && p.substring(1, 2).equals("*")) {
			if ((matched.equals(matcher) || matcher.equals("."))
					&& isMatch(s.substring(1), p, count))

				return true;

			else
				return isMatch(s, p.substring(2), count);
		} else {

			if (matched.equals(matcher) || matcher.equals(".")) {
				return isMatch(s.substring(1), p.substring(1), count - 1);
			} else {
				return false;
			}

		}

	}

	private int lessChar(String p) {
		int count = 0;
		for (char c : p.toCharArray()) {
			if (c == '*')
				count++;
		}
		return p.length() - count * 2;
	}

	public static void main(String[] args) {
		System.out.println(new RegularExpressionMatching().isMatch("baccbbcbcacacbbc",
				"c*.*b*c*ba*b*b*.a*"));
	}
}
