package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * 
 * The number of ways decoding "12" is 2.
 * 
 * @author yanfeixiang
 * 
 */
public class DecodeWays {

	private static Map<String, Integer> map = new HashMap<String, Integer>();
	static {
		map.put("", 1);
		// map.put("0", 0);
	}

	public int numDecodings(String s) {

		if (s.length() == 0)
			return 0;
		return _numDecodings(s);

	}

	public int _numDecodings(String s) {
		if (s.startsWith("0"))
			return 0;

		if (map.containsKey(s))
			return map.get(s);

		if (s.length() < 2)
			return 1;

		Integer num = Integer.valueOf(s.substring(0, 2));
		int count;
		if (num >= 10 && num <= 26) {
			count = _numDecodings(s.substring(1))
					+ _numDecodings(s.substring(2));
		} else {
			count = _numDecodings(s.substring(1));
		}
		map.put(s, count);
		return count;
	}

	public static void main(String[] args) {
		System.out.println(new DecodeWays().numDecodings("1120103"));
	}
}
