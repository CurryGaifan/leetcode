package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gaifan on 2016/6/21.
 */
public class IntersectionofTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<Integer>();

        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                i++;
                j++;
                list.add(nums1[i]);
            } else if (nums1[i] > nums2[j]) {
                j = next(nums2, j);
            } else {
                i = next(nums1, i);
            }
            if (j == -1 || i == -1)
                break;
        }
        int[] rst = new int[list.size()];
        int k = 0;
        for (int n : list) {
            rst[k++] = n;
        }

        return rst;
    }

    int next(int[] num, int i) {
        for (int j = i + 1; j < num.length; j++) {
            if (num[j] > num[i])
                return j;
        }
        return -1;
    }
}
