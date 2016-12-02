package leetcode;

import java.util.*;

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
public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        Set<Integer>[] rst = new Set[nums.length];
        Set<Integer> tmp = new HashSet();
        for (int i = 0; i < nums.length; i++) {

            Set<Integer> curSet = new HashSet();
            curSet.add(i);
            Set<Integer> set = new HashSet();
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && !set.contains(j)) {
                    if (curSet.size() < rst[j].size() + 1) {
                        curSet.clear();
                        curSet.add(i);
                        curSet.addAll(rst[j]);

                        set.addAll(rst[j]);
                    }
                }
            }
            rst[i] = curSet;

            if (tmp.size() < curSet.size())
                tmp = curSet;
        }

        List<Integer> list = new ArrayList();
        for (int index : tmp)
            list.add(nums[index]);

        return new ArrayList(list);
    }

    public static void main(String[] args) {
        System.out.println(new LargestDivisibleSubset().largestDivisibleSubset(new int[]{}));
        System.out.println(new LargestDivisibleSubset().largestDivisibleSubset(new int[]{3}));
        System.out.println(new LargestDivisibleSubset().largestDivisibleSubset(new int[]{1, 2, 3}));
        System.out.println(new LargestDivisibleSubset().largestDivisibleSubset(new int[]{1, 2, 4, 8}));
    }
}
