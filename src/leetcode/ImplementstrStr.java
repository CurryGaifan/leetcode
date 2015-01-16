package leetcode;

public class ImplementstrStr {
	public int strStr(String haystack, String needle) {
		if (haystack == null || needle == null)
			return -1;

		if (haystack.equals("") && needle.equals(""))
			return 0;

		char[] hs_array = haystack.toCharArray();
		char[] n_array = needle.toCharArray();
		for (int i = 0; i < haystack.length(); i++) {
			int j = 0;
			for (; j < needle.length() && i + j < haystack.length(); j++)
				if (hs_array[i + j] != n_array[j])
					break;

			if (j == needle.length())
				return i;

		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(new ImplementstrStr().strStr("", ""));
	}
}
