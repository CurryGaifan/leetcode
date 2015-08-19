package leetcode;

/**
 * After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.
 * <p/>
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums.length < 4) {
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                max = Math.max(max, nums[i]);
            }
            return max;
        }

        int[] dp1 = new int[nums.length - 3];
        dp1[0] = nums[2];
        for (int i = 3; i < nums.length - 1; i++) {
            dp1[i - 2] = Math.max((i > 3 ? dp1[i - 4] : 0) + nums[i], dp1[i - 3]);
        }

        int[] dp2 = new int[nums.length - 1];
        dp2[0] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            dp2[i - 1] = Math.max((i > 2 ? dp2[i - 3] : 0) + nums[i], dp2[i - 2]);
        }
        return Math.max(dp1[dp1.length - 1] + nums[0], dp2[dp2.length - 1]);
    }
}
