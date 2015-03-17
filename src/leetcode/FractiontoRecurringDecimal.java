package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * •Given numerator = 1, denominator = 2, return "0.5".
 * 
 * •Given numerator = 2, denominator = 1, return "2".
 * 
 * •Given numerator = 2, denominator = 3, return "0.(6)".
 * 
 * @author yanfeixiang
 * 
 */
public class FractiontoRecurringDecimal {
	public String fractionToDecimal(int numerator, int denominator) {
		if (numerator == 0)
			return "0";
		if (denominator == 0)
			return "NANA";
		boolean po = true;
		if (numerator > 0 && denominator > 0) {
			numerator = -numerator;
			denominator = -denominator;
		} else if (numerator < 0 && denominator > 0) {
			denominator = -denominator;
			po = false;
		} else if (numerator > 0 && denominator < 0) {
			numerator = -numerator;
			po = false;
		}

		int left = numerator / denominator;
//		System.out.println(numerator + " " + denominator);
//		System.out.println(left);

		String result = "";
		if (numerator == Integer.MIN_VALUE && denominator == -1) {
			if (po)
				result = "2147483648";
			else
				result = "" + left;
		} else {
			if (po)
				result = "" + left;
			else
				result = "-" + left;
		}

//		System.out.println(result);

		if (numerator % denominator != 0)
			result = result + ".";
		Map<Long, Integer> map = new HashMap<Long, Integer>();
		long fac = numerator % denominator;
		for (int i = result.length(); fac != 0 && !map.containsKey(fac); i++) {
			map.put(fac, i);
			fac *= 10;
			result += fac / denominator;
			fac = fac % denominator;
		}

		if (map.containsKey(fac)) {
			result = result.substring(0, map.get(fac)) + "("
					+ result.substring(map.get(fac)) + ")";
		}

		return result;

	}

	public static void main(String[] args) {

		// System.out.println(new
		// FractiontoRecurringDecimal().fractionToDecimal(
		// Integer.MIN_VALUE, Integer.MAX_VALUE));

		System.out.println((-1) % Integer.MIN_VALUE);
		System.out.println(1 % Integer.MIN_VALUE);
		System.out.println((-2f) / Integer.MIN_VALUE);
		System.out.println(2f / Integer.MIN_VALUE);

	}

}
