package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermutationSequence_2 {
	private static Map<Integer, Integer> map = new HashMap<Integer, Integer>();

	static {
		int count = 1;
		for (int i = 1; i <= 9; i++) {
			count *= i;
			map.put(i, count);
		}
	}

	public String getPermutation(int n, int k) {
		if (k <= 0 || k > map.get(n))
			return "";

		List<Integer> list = new ArrayList<Integer>();
		String result = "";
		for (int i = 1; i <= n; i++)
			list.add(i);
		k--;
		while (k > 0) {
			n--;
			int count = map.get(n);
			int x = k / count;
			k %= count;
			result += list.remove(x);
		}

		for (int i : list)
			result += i;

		return result;
	}

	public static void main(String[] args) {
		System.out.println(new PermutationSequence_2().getPermutation(3, 6));
	}
}
