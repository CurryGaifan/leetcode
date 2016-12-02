package leetcode;

import util.PrintUtil;

/**
 * Created by yanfeixiang on 2016/9/20.
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num
 * calculate the number of 1's in their binary representation and return them as an array.
 * <p/>
 * Example:
 * For num = 5 you should return [0,1,1,2,1,2].
 * <p/>
 * It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
 * Space complexity should be O(n).
 * Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 */
public class CountingBits {
    public int[] countBits(int num) {
        int[] rst = new int[num + 1];
        rst[0] = 0;
        int start = 1;
        int j = 0;
        for (int i = 1; i < rst.length; i++, j++) {
            if (j >= start) {
                j = 0;
                start = i;
            }
            rst[i] = rst[j] + 1;
        }
        return rst;
    }

    public static void main(String[] args) {
        PrintUtil.printArray(new CountingBits().countBits(17));
    }
}
