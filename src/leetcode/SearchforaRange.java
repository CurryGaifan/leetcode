package leetcode;

import util.PrintUtil;

/**
 * Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
 * 
 */
public class SearchforaRange {
	public int[] searchRange(int[] A, int target) {
		int index = range(A, target, 0, A.length - 1);
		// System.out.println("index:" + index);
		if (index == -1)
			return new int[] { -1, -1 };
		int start = index;
		int end = index;

		while (start > -1 && A[start] == target)
			start--;

		while (end < A.length && A[end] == target)
			end++;
		return new int[] { start + 1, end - 1 };
	}

	public int range(int[] A, int target, int start, int end) {
		// System.out.println("start:" + start + ",end:" + end);
		if (start > end)
			return -1;

		int middle = (start + end) / 2;
		if (target > A[middle])
			return range(A, target, middle + 1, end);
		else if (target < A[middle])
			return range(A, target, start, middle - 1);
		else
			return middle;
	}

	public static void main(String[] args) {
		int[] a = new SearchforaRange().searchRange(new int[] { 1 }, 0);
		PrintUtil.printArray(a);
	}
}
