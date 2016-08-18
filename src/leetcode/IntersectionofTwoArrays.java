package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by gaifan on 2016/6/21.
 */
public class IntersectionofTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<Integer>();
        for (int n : nums1) {
            set1.add(n);
        }
        Set<Integer> set2 = new HashSet<Integer>();
        for (int n : nums2) {
            if (set1.contains(n)) {
                set2.add(n);
            }
        }
        int[] rst = new int[set2.size()];
        int i = 0;
        for (int n : set2) {
            rst[i++] = n;
        }
        return rst;
    }

    public static void main(String[] args) {

    }
}
