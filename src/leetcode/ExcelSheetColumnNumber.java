package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ExcelSheetColumnNumber {
	private static Map<Character, Integer> map = new HashMap<Character, Integer>();
	static {
		for (int i = 1; i <= 26; i++) {
			map.put((char) ('A' + i - 1), i);
		}
	}

	public int titleToNumber(String s) {
		int sum = 0;
		char[] c = s.toCharArray();
		int fac = 1;
		for (int i = c.length - 1; i >= 0; i--) {
			sum += map.get(c[i]) * fac;
			fac *= 26;
		}
		return sum;
	}
}
