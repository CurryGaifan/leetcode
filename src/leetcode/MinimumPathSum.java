package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumPathSum {

	private Map<String, Integer> map = new HashMap<String, Integer>();

	public int minPathSum(int[][] grid) {
		return minPathSum(0, 0, grid);
	}

	private int minPathSum(int i, int j, int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		if (i == m - 1 && j == n - 1)
			return grid[i][j];
		if (map.containsKey((m - 1 - i) + "*" + (n - 1 - j))) {
			return map.get((m - 1 - i) + "*" + (n - 1 - j));
		} else {
			int num = grid[i][j]
					+ Math.min((i < m - 1 ? minPathSum(i + 1, j, grid)
							: Integer.MAX_VALUE),
							(j < n - 1 ? minPathSum(i, j + 1, grid)
									: Integer.MAX_VALUE));
			map.put((m - 1 - i) + "*" + (n - 1 - j), num);
			return num;
		}
	}

	public static void main(String[] args) {
		System.out.println(new MinimumPathSum().minPathSum(new int[][] {
				{ 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }));
	}
}
