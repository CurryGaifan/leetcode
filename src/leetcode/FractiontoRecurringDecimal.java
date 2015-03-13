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
		if (numerator == denominator)
			return "1";
		boolean numEMIN = false;
		boolean minP = false;

		String result = "";
		int fac;
		if (numerator == Integer.MIN_VALUE) {
			numEMIN = true;
			int left = numerator / denominator;
			if (left > 0) {
				minP = true;
				fac = numerator % denominator;
			} else {
				fac = -(numerator % denominator);
			}

			result = "" + left;

		} else {
			boolean po = true;
			if (numerator > 0 && denominator > 0) {

			} else if (numerator < 0 && denominator > 0) {
				numerator = -numerator;
				po = false;
			} else if (numerator > 0 && denominator < 0) {
				denominator = -denominator;
				po = false;
			} else {
				numerator = -numerator;
				denominator = -denominator;
			}

			int left = numerator / denominator;
			result = (po ? "" : "-") + left;
			fac = numerator % denominator;
		}

		if (numerator % denominator != 0)
			result = result + ".";
		System.out.println("1:  " + result);

		result += getRight(fac, denominator);

		return result;

	}

	private String getRight(int fac, int denominator) {
		System.out.println("fac: " + fac + ",denominator: " + denominator);
		String result = "";
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; fac != 0 && !map.containsKey(fac); i++) {
			map.put(fac, i);
			fac *= 10;
			result += fac / denominator;
			fac = fac % denominator;
		}

		if (map.containsKey(fac)) {
			result = result.substring(0, map.get(fac)) + "("
					+ result.substring(map.get(fac)) + ")";
		}
		System.out.println("return :" + result);
		return result;
	}

	public static void main(String[] args) {

		System.out.println(new FractiontoRecurringDecimal().fractionToDecimal(
				Integer.MIN_VALUE, Integer.MAX_VALUE));
	}

}
