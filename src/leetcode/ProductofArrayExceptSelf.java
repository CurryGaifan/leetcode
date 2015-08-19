package leetcode;

import util.PrintUtil;

/**
 * Given an array of n integers where n > 1, nums,
 * return an array output such that output[i] is equal to the product of all
 * the elements of nums except nums[i].
 * <p/>
 * Solve it without division and in O(n).
 * <p/>
 * For example, given [1,2,3,4], return [24,12,8,6].
 * <p/>
 * Follow up:
 * Could you solve it with constant space complexity?
 * (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                zeroCount++;
        }
        if (zeroCount == 0) {
            int product = 1;
            for (int i = 0; i < nums.length; i++) {
                product *= nums[i];
            }

            for (int i = 0; i < nums.length; i++) {
                nums[i] = product/nums[i];
            }

            return nums;
        } else if (zeroCount == 1) {
            int product = 1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0)
                    product *= nums[i];
            }

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0)
                    nums[i] = 0;
                else
                    nums[i] = product;

            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                nums[i] = 0;
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        PrintUtil.printArray(new ProductofArrayExceptSelf().productExceptSelf(new int[]{1, 2, 3}));
    }
}
