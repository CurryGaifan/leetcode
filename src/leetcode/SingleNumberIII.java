package leetcode;

import util.PrintUtil;

/**
 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5]
 * Your algorithm should run in linear runtime complexity.
 * Could you implement it using only constant space complexity?
 * https://discuss.leetcode.com/topic/21605/accepted-c-java-o-n-time-o-1-space-easy-solution-with-detail-explanations
 */
public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }

        diff &= -diff;

        int[] rst = new int[2];
        for (int num : nums) {
            if ((num & diff) == 0) {
                rst[0] ^= num;
            } else {
                rst[1] ^= num;
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        PrintUtil.printArray(new SingleNumberIII().singleNumber(new int[]{-1, 0}));
        PrintUtil.printArray(new SingleNumberIII().singleNumber(new int[]{1, 2, 1, 3, 2, 5}));
        PrintUtil.printArray(new SingleNumberIII().singleNumber(new int[]{-1139700704, -1653765433}));
    }
}
