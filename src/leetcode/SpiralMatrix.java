package leetcode;

import java.util.ArrayList;
import java.util.List;

import util.PrintUtil;

/**
 * [ [ 1, 2, 3 ], [ 4, 5, 6 ], [ 7, 8, 9 ] ] You should return
 * [1,2,3,6,9,8,7,4,5].
 * 
 * @author yanfeixiang
 * 
 */
public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new ArrayList<Integer>();
		if (matrix.length == 0)
			return list;

		for (int m = 0; m < Math.min(matrix.length, matrix[0].length) / 2; m++) {
			int x = m;
			int y = m;
			for (; y < matrix[0].length - 1 - m; y++) {
				list.add(matrix[x][y]);
			}
			// PrintUtil.printList(list);
			// System.out.println("x:" + x + ",y:" + y);
			for (; x < matrix.length - 1 - m; x++) {
				list.add(matrix[x][y]);
			}
			// PrintUtil.printList(list);
			for (; y > m; y--) {
				list.add(matrix[x][y]);
			}
			// PrintUtil.printList(list);
			for (; x > m; x--) {
				list.add(matrix[x][y]);
			}
			// PrintUtil.printList(list);
		}

		if (Math.min(matrix.length, matrix[0].length) % 2 == 1) {
			if (matrix.length > matrix[0].length) {
				for (int i = matrix[0].length / 2; i < matrix.length
						- matrix[0].length / 2; i++)
					list.add(matrix[i][matrix[0].length / 2]);
			} else {
				for (int i = matrix.length / 2; i < matrix[0].length
						- matrix.length / 2; i++)
					list.add(matrix[matrix.length / 2][i]);
			}

		}

		return list;
	}

	public static void main(String[] args) {
		List<Integer> list = new SpiralMatrix().spiralOrder(new int[][] {
				{ 2 ,3,4} });
		PrintUtil.printList(list);

	}
}
