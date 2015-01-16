package leetcode;

import util.PrintUtil;

/**
 * [1,3,5,6], 5 ¡ú 2 [1,3,5,6], 2 ¡ú 1 [1,3,5,6], 7 ¡ú 4 [1,3,5,6], 0 ¡ú 0
 * 
 * @author yanfeixiang
 * 
 */
public class SearchInsertPosition {
	public int searchInsert(int[] A, int target) {
		if (A.length == 0)
			return 0;
		int index = range(A, target, 0, A.length - 1);
//		System.out.println("index:" + index);
		if (index == A.length)
			return index;
		if (A[index] < target)
			return index + 1;
		else
			return index;
	}

	public int range(int[] A, int target, int start, int end) {
		// System.out.println("start:" + start + ",end:" + end);
		if (start > end)
			return start;

		int middle = (start + end) / 2;
		if (target > A[middle])
			return range(A, target, middle + 1, end);
		else if (target < A[middle])
			return range(A, target, start, middle - 1);
		else
			return middle;
	}

	public static void main(String[] args) {
		System.out.println(new SearchInsertPosition().searchInsert(new int[] {
				1, 3, 5, 7, 9 }, 10));
	}
}
