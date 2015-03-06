package leetcode;

public class MaximumProductSubarray {
	public int maxProduct(int[] A) {

		int max = Integer.MIN_VALUE;
		int sub1 = 1;
		int sub2 = 1;

		for (int i = 0; i < A.length; i++) {
			// max = Math.max(max, A[i]);
			if (A[i] == 0) {
				max = Math.max(max, 0);
				sub1 = 1;
				sub2 = 1;

			} else {

				if (sub2 == 1 && sub1 > 0) {

				} else {
					sub2 *= A[i];
					max = Math.max(max, sub2);
				}

				sub1 *= A[i];
				max = Math.max(max, sub1);

			}
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(new MaximumProductSubarray()
				.maxProduct(new int[] { -2 }));
	}
}
