package leetcode;

/**
 * Created by yanfeixiang on 2016/9/14.
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * <p/>
 * For example,
 * Given [10, 9, 2, 5, 3, 7, 101, 18],
 * The longest increasing subsequence is [2, 3, 7, 101],
 * therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.
 * <p/>
 * Your algorithm should run in O(n2) complexity.
 * <p/>
 * Follow up: Could you improve it to O(n log n) time complexity?
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0)
            return 0;
        int max = 1;
        int[] ar = new int[nums.length];
        ar[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int tmp = Integer.MIN_VALUE;
            int cur = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] <= tmp || nums[i] <= nums[j]) {
                    continue;
                }

                tmp = nums[j];
                cur = Math.max(cur, ar[j] + 1);
            }
            ar[i] = cur;
            max = Math.max(max, cur);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(new int[]{0}));
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(new int[]{}));
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(new int[]{2, 2}));
    }
}
