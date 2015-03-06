package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 
 * 1 -> A 2 -> B 3 -> C ... 26 -> Z 27 -> AA 28 -> AB
 * 
 * @author yanfeixiang
 * 
 */
public class ExcelSheetColumnTitle {
	private static Map<Integer, String> map = new HashMap<Integer, String>();
	static {
		for (int i = 1; i <= 26; i++) {
			map.put(i, String.valueOf((char) ('A' + i -1)));
		}
	}

	public String convertToTitle(int n) {
		String title = "";
		while (n > 26) {
			title = map.get((n - 1) % 26 + 1) + title;
			n = (n - 1) / 26;
		}
		title = map.get(n) + title;
		return title;
	}

}
