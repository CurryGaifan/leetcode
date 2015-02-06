package leetcode;

import java.util.HashMap;
import java.util.Map;

public class UniquePaths {
	private static Map<String, Integer> map = new HashMap<String, Integer>();

	public int uniquePaths(int m, int n) {
		return uniquePaths(0, 0, m, n);
	}

	public int uniquePaths(int i, int j, int m, int n) {
		if (i == m - 1 && j == n - 1)
			return 1;
		if (map.containsKey((m - 1 - i) + "*" + (n - 1 - j))) {
			return map.get((m - 1 - i) + "*" + (n - 1 - j));
		} else {
			int num = (i < m - 1 ? uniquePaths(i + 1, j, m, n) : 0)
					+ (j < n - 1 ? uniquePaths(i, j + 1, m, n) : 0);
			map.put((m - 1 - i) + "*" + (n - 1 - j), num);
			return num;
		}

	}

	public static void main(String[] args) {
		System.out.println(new UniquePaths().uniquePaths(23, 12));
	}
}
