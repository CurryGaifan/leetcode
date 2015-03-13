package leetcode;

import util.PrintUtil;

/**
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to
 * [5,6,7,1,2,3,4].
 * 
 * @author yanfeixiang
 * 
 */
public class RotateArray {
	public void rotate(int[] nums, int k) {
		if (nums.length == 0)
			return;

		k = k % nums.length;
		int mc = getMC(nums.length, k);
		System.out.println(mc);
		for (int j = 0; j < mc; j++) {

			int start = j;
			int tmp = nums[start];
			for (int l = 0; l < nums.length / mc - 1; l++) {
				nums[start] = nums[(start + nums.length - k) % nums.length];
				start = (start + nums.length - k) % nums.length;
			}
			nums[start] = tmp;
		}

	}

	private int getMC(int a, int b) {
		int min = Math.min(a, b);
		int max = 1;
		for (int i = 1; i <= min / 2; i++) {
			if (a % i == 0 && b % i == 0) {
				max = i;
				if (a % (min / i) == 0 && b % (min / i) == 0) {
					return min / i;
				}

			}
		}
		return max;
	}

	public static void main(String[] args) {

		int[] a = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,
				15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
				31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46,
				47, 48, 49, 50, 51, 52, 53, 54 };
		new RotateArray().rotate(a, 45);
		PrintUtil.printArray(a);
	}
}
