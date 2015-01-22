package leetcode;

/**
 * 1 is read off as "one 1" or 11. 11 is read off as "two 1s" or 21. 21 is read
 * off as "one 2, then one 1" or 1211. 111221, 312211
 * 
 */
public class CountandSay {
	public String countAndSay(int n) {
		return countAndSay("1", n - 1);
	}

	private String countAndSay(String str, int n) {
		// System.out.println("n: " + n);
		if (n <= 0)
			return str;
		String resultStr = "";
		int start = 0;
		while (start < str.length()) {
			int end = findend(str, start);
			// System.out.println("end:" + end);
			int length = end - start + 1;
			resultStr += length + "" + (str.charAt(start) - '0');
			start = end + 1;
		}
		// System.out.println(resultStr);
		return countAndSay(resultStr, n - 1);
	}

	private int findend(String str, int index) {
		// System.out.println("start:" + index);
		char c = str.charAt(index);
		int i = 0;
		for (; i + index < str.length() && str.charAt(i + index) == c; i++)
			;

		return index + i - 1;
	}

	public static void main(String[] args) {
		System.out.println(new CountandSay().countAndSay(2));
	}
}
