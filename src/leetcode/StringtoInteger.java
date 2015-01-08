package leetcode;

public class StringtoInteger {
	// Input: "  -0012a42"
	// Output: 0
	// Expected: -12

	public int atoi(String str) {
		while (str.startsWith(" "))
			str = str.substring(1);
		boolean negative = false;
		if (str.startsWith("+"))
			str = str.substring(1);
		else {
			negative = str.startsWith("-");
			if (negative)
				str = str.substring(1);
		}

		char[] chars = str.toCharArray();
		int num = 0;
		int last = 0;
		for (char c : chars) {
			if ('0' <= c && c <= '9') {
				num = num * 10 + (c - '0');
				// System.out.println(num);
				if ((num < 0 || (num - (c - '0')) / 10 != last) && negative)
					return Integer.MIN_VALUE;
				if ((num < 0 || (num - (c - '0')) / 10 != last) && !negative)
					return Integer.MAX_VALUE;
			} else
				break;
			last = num;
		}

		return negative ? -num : num;
	}

	public static void main(String[] args) {
		System.out.println(new StringtoInteger().atoi("    10522545459"));
	}
}
