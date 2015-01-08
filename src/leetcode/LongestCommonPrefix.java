package leetcode;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0)
			return "";
		String lcp = strs[0];
		for (int i = 1; i < strs.length; i++) {
			lcp = longestCommonPrefix(lcp, strs[i]);

		}
		return lcp;

	}

	public String longestCommonPrefix(String str1, String str2) {
		char[] chars1 = str1.toCharArray();
		char[] chars2 = str2.toCharArray();
		int i = 0;
		for (; i < str1.length() && i < str2.length(); i++) {
			if (chars1[i] != chars2[i])
				return str1.substring(0, i);
		}
		return str1.substring(0, i);

	}

	public static void main(String[] args) {
		System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[] {}));
	}
}
