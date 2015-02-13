package leetcode;

import util.PrintUtil;

/**
 * You may assume that A has enough space (size that is greater or equal to m +
 * n) to hold additional elements from B. The number of elements initialized in
 * A and B are m and n respectively.
 * 
 * @author yanfeixiang
 * 
 */
public class MergeSortedArray {
	public void merge(int A[], int m, int B[], int n) {

		System.arraycopy(A, 0, A, A.length - m, m);
		int i = A.length - m;
		int j = 0;
		int k = 0;
		while (i < A.length && j < n)
			if (A[i] > B[j])
				A[k++] = B[j++];
			else
				A[k++] = A[i++];

		if (i < A.length)
			System.arraycopy(A, i, A, k, A.length - i);
		else if (j < n)

			System.arraycopy(B, j, A, k, n - j);

	}

	public static void main(String[] args) {
		int[] A = new int[] { 1, 2, 3, 4, 9, 0, 0, 0, 0, 0, 0 };
		int[] B = new int[] { 2, 3, 5, 7, 7 };
		new MergeSortedArray().merge(A, 5, B, 5);
		PrintUtil.printArray(A);
	}
}
