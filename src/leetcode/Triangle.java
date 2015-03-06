package leetcode;

import java.util.List;

/**
 * For example, given the following triangle [ [2], [3,4], [6,5,7], [4,1,8,3] ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * @author yanfeixiang
 * 
 */
public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle.size() == 0)
			return 0;

		int[] array = new int[triangle.size()];
		array[0] = triangle.get(0).get(0);
		for (int i = 1; i < triangle.size(); i++) {
			for (int j = triangle.get(i).size() - 1; j >= 0; j--) {
				array[j] = Math.min(j == 0 ? Integer.MAX_VALUE : array[j - 1],
						j == triangle.get(i).size() - 1 ? Integer.MAX_VALUE
								: array[j])
						+ triangle.get(i).get(j);
			}

		}
		int min = array[0];
		for (int i = 0; i < array.length; i++) {
			min = Math.min(min, array[i]);
		}
		return min;
	}
}
