package leetcode;

import util.PrintUtil;

/**
 * Given sorted array A = [1,1,1,2,2,3],
 * 
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 * 
 * @author yanfeixiang
 * 
 */
public class RemoveDuplicatesfromSortedArrayII {
	public int removeDuplicates(int[] A) {

		if (A.length == 0)
			return 0;
		int index = 0;
		for (int i = 0; i < A.length; i++) {
			if (index < 2 || A[i] != A[index - 1]
					|| (A[i] == A[index - 1] && A[i] != A[index - 2])) {
				A[index] = A[i];
				index++;
			}

		}

		return index;
	}

	public static void main(String[] args) {
		int[] A = new int[] { 1 };
		System.out.println(new RemoveDuplicatesfromSortedArrayII()
				.removeDuplicates(A));
		PrintUtil.printArray(A);
	}
}
