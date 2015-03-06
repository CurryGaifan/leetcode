package leetcode;

/**
 * "A man, a plan, a canal: Panama" is a palindrome.
 * 
 * "race a car" is not a palindrome.
 * 
 * @author yanfeixiang
 * 
 */
public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		s = s.trim().toLowerCase();
		if (s.length() == 0)
			return true;
		char[] c = s.toCharArray();
		int i = 0;
		int j = c.length - 1;
		while (i <= j) {

			while (i <= j) {
				if (('a' <= c[i] && c[i] <= 'z')
						|| ('0' <= c[i] && c[i] <= '9')) {
					break;
				} else {
					i++;
				}
			}

			while (i <= j) {
				if (('a' <= c[j] && c[j] <= 'z')
						|| ('0' <= c[j] && c[j] <= '9')) {
					break;
				} else {
					j--;
				}
			}
			if (i > j)
				return true;

			if (c[i] == c[j]) {
				if (i >= j - 1)
					return true;
				else {
					i++;
					j--;
				}
			} else {
				return false;
			}

		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(new ValidPalindrome()
				.isPalindrome("A man, a plan, a canal: Panama"));

		System.out.println(new ValidPalindrome().isPalindrome("race a car"));

		System.out.println(new ValidPalindrome().isPalindrome(""));

		System.out.println(new ValidPalindrome().isPalindrome(" a"));
		System.out.println(new ValidPalindrome().isPalindrome("."));
	}
}
