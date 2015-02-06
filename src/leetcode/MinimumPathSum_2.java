package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumPathSum_2 {

	public int minPathSum(int[][] grid) {
		for (int i = grid[0].length - 2; i >= 0; i--) {
			grid[grid.length - 1][i] += grid[grid.length - 1][i + 1];
		}

		for (int i = grid.length - 2; i >= 0; i--) {
			grid[i][grid[0].length - 1] += grid[i + 1][grid[0].length - 1];
		}

		for (int i = grid.length - 2; i >= 0; i--) {
			for (int j = grid[0].length - 2; j >= 0; j--) {
				grid[i][j] += Math.min(grid[i + 1][j], grid[i][j + 1]);
			}
		}
		return grid[0][0];

	}

	public static void main(String[] args) {
		System.out.println(new MinimumPathSum_2().minPathSum(new int[][] {
				{ 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }));
	}
}
