package leetcode;

/**
 * Given [1,2,0] return 3, and [3,4,-1,1] return 2.
 * 
 * @author yanfeixiang
 * 
 */
public class FirstMissingPositive {
	public int firstMissingPositive(int[] A) {

		for (int i = 0; i < A.length; i++) {
			while (A[i] != i + 1 && A[i] > 0 && A[i] < A.length
					&& A[i] != A[A[i] - 1]) {
				swap(A, i, A[i] - 1);
			}
		}

		for (int i = 0; i < A.length; i++) {
			if (A[i] != i + 1)
				return i + 1;
		}
		return A.length + 1;
	}

	private void swap(int[] A, int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}

	public static void main(String[] args) {
		System.out.println(new FirstMissingPositive()
				.firstMissingPositive(new int[] { 0 }));
	}
}
