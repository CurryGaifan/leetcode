package leetcode;

/**
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4], the contiguous subarray
 * [4,−1,2,1] has the largest sum = 6.
 * 
 * @author yanfeixiang
 * 
 */
public class MaximumSubarray {
	public int maxSubArray(int[] A) {
		if (A.length == 0)
			return 0;

		int maxSum = A[0];
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
			maxSum = Math.max(maxSum, sum);
			if (sum < 0)
				sum = 0;
		}

		return maxSum;
	}

	public static void main(String[] args) {
		System.out.println(new MaximumSubarray().maxSubArray(new int[] {}));
	}
}
