package leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < numbers.length; i++) {
			if (map.containsKey(target - numbers[i])) {
				return new int[] { map.get(target - numbers[i]) + 1, i + 1 };
			} else {
				map.put(numbers[i], i);
			}
		}
		return new int[2];
	}

	public static void main(String[] args) {
		TwoSum q1 = new TwoSum();
		for (int i : q1.twoSum(new int[] { 2, 7, 11, 15 }, 26)) {
			System.out.println(i);
		}
	}
}
