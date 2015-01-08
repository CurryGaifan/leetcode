package leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomantoInteger {

	static Map<Character, Integer> map = new HashMap<Character, Integer>();
	static {
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
	}

	public int romanToInt(String s) {
		int num = 0;
		char[] ar_s = s.toCharArray();
		int i = 0;

		while (i < s.length()) {
			char c = ar_s[i];
			int step = goStep(ar_s, i);
			if (step == 1) {
				num += map.get(c);
			} else if (step == 2) {
				if (c == ar_s[i + 1])
					num += map.get(c) * 2;
				else
					num += map.get(ar_s[i + 1]) - map.get(c);
			} else {
				num += map.get(c) * 3;
			}
			i += step;
		}
		return num;
	}

	private int goStep(char[] ar_s, int i) {
		int num = map.get(ar_s[i]);
		int j = i + 1;
		for (; j < ar_s.length; j++) {
			if (map.get(ar_s[j]) < num)
				return j - i;
		}
		return j - i;
	}

	public static void main(String[] args) {

	}
}
