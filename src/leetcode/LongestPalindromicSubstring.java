package leetcode;

public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		char[] chars = s.toCharArray();
		int length = 0;
		String str = "";
		for (int i = 0; i < s.length(); i++) {
			int j = 1;
			for (; i - j > -1 && i + j < s.length(); j++) {

				if (chars[i - j] != chars[i + j])
					break;

			}
			if ((j - 1) * 2 + 1 > length) {
				str = s.substring(i - j + 1, i + j);
				length = (j - 1) * 2 + 1;
			}

			j = 0;
			for (; i - j > -1 && i + j + 1 < s.length(); j++) {

				if (chars[i - j] != chars[i + j + 1])
					break;

			}
			if ((j - 1) * 2 + 2 > length) {
				str = s.substring(i - j + 1, i + j + 1);
				length = (j - 1) * 2 + 2;
			}

		}
		return str;
	}

	public static void main(String[] args) {
		System.out.println(new LongestPalindromicSubstring().longestPalindrome("cabtttttttbac"));
	}
}
