package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * 
 * Note: The result may be very large, so you need to return a string instead of
 * an integer.
 * 
 * I thinked complexity.solve the problem with help.
 * https://leetcode.com/discuss/23422/my-java-solution-to-share
 * 
 * @author yanfeixiang
 * 
 */
public class LargestNumber {
	public String largestNumber(int[] num) {

		List<String> list = new ArrayList<String>();
		for (int n : num) {
			list.add(String.valueOf(n));
		}

		Comparator<String> c = new Comparator<String>() {

			@Override
			public int compare(String str1, String str2) {
				return (str1 + str2).compareTo(str2 + str1);

			}
		};

		Collections.sort(list, c);
		if (list.get(list.size() - 1).equals("0"))
			return "0";

		String result = "";
		for (String s : list) {
			result = s + result;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(new LargestNumber().largestNumber(new int[] { 12,
				128 }));
	}
}
