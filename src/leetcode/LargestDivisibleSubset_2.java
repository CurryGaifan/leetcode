package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yanfeixiang on 2016/9/21.
 * Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj)
 * of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.
 * <p/>
 * If there are multiple solutions, return any subset is fine.
 * <p/>
 * Example 1:
 * <p/>
 * nums: [1,2,3]
 * <p/>
 * Result: [1,2] (of course, [1,3] will also be ok)
 * Example 2:
 * <p/>
 * nums: [1,2,4,8]
 * <p/>
 * Result: [1,2,4,8]
 */
public class LargestDivisibleSubset_2 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> rst = new ArrayList<>();
        if (nums.length == 0) {
            return rst;
        }

        Arrays.sort(nums);
        rst.add(nums[0]);
        for (int i = 0; i < nums.length; i++) {

            List<Integer> tmp = new ArrayList<>();
            tmp.add(nums[i]);

            help(i, nums, rst, tmp);
        }
        return rst;

    }

    private void help(int index, int[] nums, List<Integer> list, List<Integer> tmp) {

        for (int i = index + 1; i < nums.length; i++) {
            if (nums[i] % nums[index] == 0) {
                tmp.add(nums[i]);
                help(i, nums, list, tmp);
                tmp.remove(tmp.size() - 1);
            }

            if (i == nums.length - 1 && tmp.size() > list.size()) {
                list.clear();
                list.addAll(tmp);
                if (nums[i] % nums[index] == 0)
                    list.add(nums[i]);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new LargestDivisibleSubset_2().largestDivisibleSubset(new int[]{}));
        System.out.println(new LargestDivisibleSubset_2().largestDivisibleSubset(new int[]{3}));
        System.out.println(new LargestDivisibleSubset_2().largestDivisibleSubset(new int[]{1, 2, 3}));
        System.out.println(new LargestDivisibleSubset_2().largestDivisibleSubset(new int[]{1, 2, 4, 8}));
        System.out.println(new LargestDivisibleSubset_2().largestDivisibleSubset(new int[]{3, 4, 16, 8}));
    }
}
