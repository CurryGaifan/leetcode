package leetcode;

import java.util.HashMap;
import java.util.Map;

public class IntegertoRoman {

	static Map<Integer, String> map = new HashMap<Integer, String>();
	static {
		map.put(1, "I");
		map.put(5, "V");
		map.put(10, "X");
		map.put(50, "L");
		map.put(100, "C");
		map.put(500, "D");
		map.put(1000, "M");
	}

	public String intToRoman(int num) {
		String romanString = "";
		for (int i = 1; num > 0; i *= 10) {
			int num1 = num % 10;
			String tmp = "";
			if (1 <= num1 && num1 <= 3) {
				for (int j = 0; j < num1; j++)
					tmp += map.get(i);
			} else if (num1 == 4) {
				tmp = map.get(i) + map.get(5 * i);
			} else if (5 <= num1 && num1 <= 8) {
				tmp = map.get(5 * i);
				for (int j = 0; j < num1 - 5; j++)
					tmp += map.get(i);
			} else if (num1 == 9) {
				tmp = map.get(i) + map.get(10 * i);
			}
			romanString = tmp + romanString;
			num /= 10;
		}

		return romanString;
	}
	public static void main(String[] args) {
		System.out.println(new IntegertoRoman().intToRoman(955));
	}
}
