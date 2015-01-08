package leetcode;

public class RemoveDuplicatesfromSortedArray {
	public int removeDuplicates(int[] A) {
		if (A == null || A.length == 0)
			return 0;
		int index = 0;
		for (int i = 1; i < A.length; i++) {
			if (i == 0) {
				A[index] = A[i];
			} else if (A[index] != A[i]) {
				A[++index] = A[i];
			}
		}
		return index + 1;

	}

	public static void main(String[] args) {
		int[] A = new int[] { 1,1 };
		int count = new RemoveDuplicatesfromSortedArray().removeDuplicates(A);
		System.out.println(count);
		for (int i = 0; i < count; i++)
			System.out.print(A[i]);
	}
}
