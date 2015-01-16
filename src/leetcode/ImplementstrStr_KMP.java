package leetcode;

public class ImplementstrStr_KMP {
	public int strStr(String haystack, String needle) {

		if (haystack == null && needle == null)
			return -1;

		if (needle.length() == 0)
			return 0;

		char[] s = haystack.toCharArray();
		char[] t = needle.toCharArray();

		int[] next = next(t);
		int i = 0;
		int j = 0;
		while (i <= s.length - 1 && j <= t.length - 1) {
			if (j == -1 || s[i] == t[j]) {
				i++;
				j++;
			} else {
				j = next[j];
			}
		}
		if (j < t.length) {
			return -1;
		} else
			return i - t.length;
	}

	public int[] next(char[] t) {
		int[] next = new int[t.length];
		next[0] = -1;
		int i = 0;
		int j = -1;
		while (i < t.length - 1) {
			if (j == -1 || t[i] == t[j]) {
				i++;
				j++;
				if (t[i] != t[j]) {
					next[i] = j;
				} else {
					next[i] = next[j];
				}
			} else {
				j = next[j];
			}
		}
		return next;
	}

	public static void main(String[] args) {
		String str = "abcdabd";
		int[] next_array = new ImplementstrStr_KMP().next(str
				.toCharArray());

		for (int next : next_array) {
			System.out.print(next + " ");
		}
		System.out.println();

		System.out.println(new ImplementstrStr_KMP().strStr("aaa", "aaaa"));
	}
}
