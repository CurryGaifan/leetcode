package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * S = "ADOBECODEBANC" T = "ABC" Minimum window is "BANC".
 * 
 * @author yanfeixiang
 * 
 */
public class MinimumWindowSubstring {
	public String minWindow(String S, String T) {

		char[] s_a = S.toCharArray();
		char[] t_a = T.toCharArray();

		Map<Character, Integer> map_r_count = new HashMap<Character, Integer>();
		for (char c : t_a) {

			if (map_r_count.containsKey(c)) {
				map_r_count.put(c, map_r_count.get(c) + 1);
			} else {
				map_r_count.put(c, 1);
			}
		}

		Queue<Integer> index = new LinkedList<Integer>();
		Map<Character, Integer> map_count = new HashMap<Character, Integer>();
		int minWdLength = Integer.MAX_VALUE;
		String result = "";
		boolean find = false;
		for (int i = 0; i < S.length(); i++) {
			if (map_r_count.containsKey(s_a[i])) {
				index.add(i);
				if (map_count.containsKey(s_a[i])) {
					map_count.put(s_a[i], map_count.get(s_a[i]) + 1);
				} else {
					map_count.put(s_a[i], 1);
				}

				while (map_count.get(s_a[index.peek()]) > map_r_count
						.get(s_a[index.peek()])) {
					int e = index.remove();
					if (map_count.get(s_a[e]) == 1) {
						map_count.remove(s_a[i]);
					} else {
						map_count.put(s_a[e], map_count.get(s_a[e]) - 1);
					}
				}

				if (!find) {
					find = isFind(map_r_count, map_count);
				}

				if (find) {
					int e = index.peek();
					if (i - e + 1 < minWdLength) {
						minWdLength = i - e + 1;
						result = S.substring(e, i + 1);
						// System.out.println(result + " " + (i - e + 1));
					}
				}

			}

		}
		return result;

	}

	private boolean isFind(Map<Character, Integer> map_r_count,
			Map<Character, Integer> map_count) {
		if (map_r_count.size() != map_count.size())
			return false;

		for (Map.Entry<Character, Integer> entry : map_r_count.entrySet()) {
			if (map_count.get(entry.getKey()) < entry.getValue())
				return false;
		}
		return true;

	}

	public static void main(String[] args) {
		System.out.println(new MinimumWindowSubstring().minWindow(
				"cabwefgewcwaefgcf", "cae"));
	}
}
