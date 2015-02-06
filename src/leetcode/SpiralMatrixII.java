package leetcode;

import util.PrintUtil;

public class SpiralMatrixII {
	public int[][] generateMatrix(int n) {
		int[][] array = new int[n][n];
		int num = 1;

		for (int m = 0; m < (n + 1) / 2; m++) {
			System.out.println("m:" + m);
			int x = m;
			int y = m;
			for (; y < n - 1 - m; y++) {
				array[x][y] = num++;
			}
			// PrintUtil.printList(list);
			// System.out.println("x:" + x + ",y:" + y);
			for (; x < n - 1 - m; x++) {
				array[x][y] = num++;
			}
			// PrintUtil.printList(list);
			for (; y > m; y--) {
				array[x][y] = num++;
			}
			// PrintUtil.printList(list);
			for (; x > m; x--) {
				array[x][y] = num++;
			}
		}
		if (n % 2 == 1)
			array[n / 2][n / 2] = num;
		return array;
	}

	public static void main(String[] args) {
		int[][] array = new SpiralMatrixII().generateMatrix(5);
		PrintUtil.printArray(array);
	}
}
