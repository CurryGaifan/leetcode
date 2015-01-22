package leetcode;

import util.PrintUtil;

public class RotateImage {
	public void rotate(int[][] matrix) {

		int tmp2;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i; j < matrix.length - i - 1; j++) {
				// System.out.println("i:" + i + ",j:" + j);
				int tmp1 = matrix[i][j];
				int m = i;
				int n = j;
				for (int k = 0; k < 4; k++) {
					int _m = n;
					int _n = matrix.length - 1 - m;
					tmp2 = matrix[_m][_n];
					matrix[_m][_n] = tmp1;
					tmp1 = tmp2;
					m = _m;
					n = _n;
					// System.out.println("matrix[" + _m + "][" + _n + "]:"
					// + matrix[_m][_n]);
				}

			}
		}
	}

	public static void main(String[] args) {
		int[][] a = new int[][] { { 1, 2, 3, 4 }, { 4, 5, 6, 7 },
				{ 7, 8, 9, 10 }, { 10, 11, 12, 13 } };
		new RotateImage().rotate(a);
		PrintUtil.printArray(a);
	}
}
