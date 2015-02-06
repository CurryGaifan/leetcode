package leetcode;

import java.util.HashMap;
import java.util.Map;

public class UniquePathsII_2 {
	private Map<String, Integer> map = new HashMap<String, Integer>();

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		return uniquePaths(0, 0, obstacleGrid);
	}

	public int uniquePaths(int i, int j, int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		if (obstacleGrid[i][j] == 1)
			return 0;

		if (i == m - 1 && j == n - 1)
			return 1;
		if (map.containsKey((m - 1 - i) + "*" + (n - 1 - j))) {
			return map.get((m - 1 - i) + "*" + (n - 1 - j));
		} else {
			int num = 0;
			if (i == m - 1) {
				while (j < n && obstacleGrid[i][j] != 1)
					j++;
				if (j == n)
					num = 1;
			} else {
				for (int k = j; k < n && obstacleGrid[i][k] != 1; k++) {
					num += uniquePaths(i + 1, k, obstacleGrid);
				}
			}
			map.put((m - 1 - i) + "*" + (n - 1 - j), num);
			return num;
		}

	}

	public static void main(String[] args) {
		System.out.println(new UniquePathsII_2()
				.uniquePathsWithObstacles(new int[][] { { 0, 0, 0 }, }));
	}

}
