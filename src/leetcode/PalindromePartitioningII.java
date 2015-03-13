package leetcode;

import java.util.HashMap;
import java.util.Map;

import util.PrintUtil;

/**
 * @author yanfeixiang
 * 
 */
public class PalindromePartitioningII {
	public int minCut(String s) {
		long start = System.currentTimeMillis();
		Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
		Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
		for (int i = 1; i < s.length() - 1; i++) {
			int j = 1;
			for (; i - j >= 0 && i + j < s.length()
					&& s.charAt(i - j) == s.charAt(i + j); j++)
				;
			if (j != 1)
				map1.put(i, j - 1);

		}

		for (int i = 0; i < s.length() - 1; i++) {
			int

			j = 0;
			for (; i - j >= 0 && i + j + 1 < s.length()
					&& s.charAt(i - j) == s.charAt(i + j + 1); j++)
				;
			if (j != 0)
				map2.put(i, j - 1);

		}
		// System.out.println(map1);
		// System.out.println("==================");
		// System.out.println(map2);
		int[] mins = new int[s.length()];
		mins[0] = 0;
		for (int i = 1; i < s.length(); i++) {
			int min = mins[i - 1] + 1;
			if (isPalind(map1, map2, 0, i)) {
				// System.out.println("Palind:" + 0 + " " + i);
				mins[i] = 0;
			} else {
				for (int j = 0; j < i; j++) {

					if ((min == mins[i - 1] + 1 && (mins[j] + 2 == min || mins[j] + 3 == min))
							|| (min == mins[i - 1] && mins[j] + 2 == min)) {
						// System.out.println("i:" + i + ",j:" + j);
						if (isPalind(map1, map2, j + 1, i)) {
							min = Math.min(min, mins[j] + 1);
							// System.out.println("min:" + min);
							if (min == mins[i - 1] - 1 || min == 1)
								break;
						}
					}

				}

				mins[i] = min;
			}

		}

		long end = System.currentTimeMillis();
		// System.out.println(end - start);
		// PrintUtil.printArray(mins);
		return mins[s.length() - 1];
	}

	private boolean isPalind(Map<Integer, Integer> map1,
			Map<Integer, Integer> map2, int start, int end) {
		if ((start - end) % 2 == 0)
			return map1.containsKey((start + end) / 2)
					&& (end - start) / 2 <= map1.get((start + end) / 2);
		else
			return map2.containsKey((start + end) / 2)
					&& (end - start) / 2 <= map2.get((start + end) / 2);
	}

	public static void main(String[] args) {
		System.out
				.println(new PalindromePartitioningII()
						.minCut("fifgbeajcacehiicccfecbfhhgfiiecdcjjffbghdidbhbdbfbfjccgbbdcjheccfbhafehieabbdfeigbiaggchaeghaijfbjhi"));
		System.out
				.println(new PalindromePartitioningII()
						.minCut("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
		System.out.println(new PalindromePartitioningII().minCut("saddsea"));
		System.out.println(new PalindromePartitioningII().minCut("bb"));

	}
}
