package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * For example, Given [100, 4, 200, 1, 3, 2], The longest consecutive elements
 * sequence is [1, 2, 3, 4]. Return its length: 4.
 * 
 * @author yanfeixiang
 * 
 */
public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] num) {
		Map<Integer, Integer> start_end = new HashMap<Integer, Integer>();
		Map<Integer, Integer> end_start = new HashMap<Integer, Integer>();
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < num.length; i++) {
			if (set.contains(num[i]))
				continue;

			set.add(num[i]);

			boolean bse = start_end.containsKey(num[i] + 1);
			boolean bes = end_start.containsKey(num[i] - 1);
			if (bse && bes) {
				int se = start_end.remove(num[i] + 1);
				int es = end_start.remove(num[i] - 1);
				start_end.put(es, se);
				end_start.put(se, es);
			} else if (bse) {
				int se = start_end.remove(num[i] + 1);
				start_end.put(num[i], se);
				end_start.put(se, num[i]);
			} else if (bes) {
				int es = end_start.remove(num[i] - 1);
				end_start.put(num[i], es);
				start_end.put(es, num[i]);
			} else {
				end_start.put(num[i], num[i]);
				start_end.put(num[i], num[i]);
			}

		}
		int length = 0;
		for (Map.Entry<Integer, Integer> entry : start_end.entrySet()) {
			length = Math.max(length, entry.getValue() - entry.getKey() + 1);
		}
		return length;
	}

	public static void main(String[] args) {
		System.out.println(new LongestConsecutiveSequence()
				.longestConsecutive(new int[] { -7, -1, 3, -9, -4, 7, -3, 2, 4,
						9, 4, -9, 8, -7, 5, -1, -7 }));
	}
}
