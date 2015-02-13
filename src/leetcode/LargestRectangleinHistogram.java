package leetcode;

/*
 * Given height = [2,1,5,6,2,3],
 * return 10.
 */
public class LargestRectangleinHistogram {
	public int largestRectangleArea(int[] height) {
		if (height.length == 0)
			return 0;
		return findLargest(height, 0, height.length - 1);

	}

	private int findLargest(int[] height, int i, int j) {
		if (i > j)
			return 0;
		int minHeight = findMin(height, i, j);
		int max = minHeight * (j - i + 1);
		int start = i;
		int k = i;
		for (; k <= j; k++) {
			if (height[k] == minHeight) {
				max = Math.max(max, findLargest(height, start, k - 1));
				start = k + 1;
			}
		}
		max = Math.max(max, findLargest(height, start, k - 1));
		return max;

	}

	private int findMin(int[] height, int i, int j) {
		int min = Integer.MAX_VALUE;
		for (int k = i; k <= j; k++) {
			min = Math.min(min, height[k]);
		}
		return min;
	}

	public static void main(String[] args) {
		System.out.println(new LargestRectangleinHistogram()
				.largestRectangleArea(new int[] {}));
	}
}
