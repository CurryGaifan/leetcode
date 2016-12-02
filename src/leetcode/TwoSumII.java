package leetcode;

import util.PrintUtil;

import java.util.Arrays;

/**
 * Created by yanfeixiang on 2016/9/8.
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * <p/>
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 * Please note that your returned answers (both index1 and index2) are not zero-based.
 * <p/>
 * You may assume that each input would have exactly one solution.
 * <p/>
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */
public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length < 2)
            return new int[2];

        for (int i = 0; i < numbers.length - 1; i++) {
            if (i > 0 && numbers[i - 1] == numbers[i])
                continue;
            int index = Arrays.binarySearch(numbers, i + 1, numbers.length , target - numbers[i]);
            if (index > 0)
                return new int[]{i + 1, index + 1};
        }
        return new int[2];

    }

    public static void main(String[] args) {
        PrintUtil.printArray(new TwoSumII().twoSum(new int[]{2, 7, 11, 15}, 9));
        PrintUtil.printArray(new TwoSumII().twoSum(new int[]{2, 3, 4}, 6));
    }
}
