package leetcode;

/**
 * Given a range [m, n] where 0 <= m <= n <= 2147483647,
 * return the bitwise AND of all numbers in this range, inclusive.
 * <p/>
 * For example, given the range [5, 7], you should return 4.
 */
public class BitwiseANDofNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0) {
            return 0;
        }
        int count = 0;
        while (m != n) {
            m >>>= 1;
            n >>>= 1;
            count++;
        }
        return m <<= count;

    }

    public static void main(String[] args) {
        System.out.println(new BitwiseANDofNumbersRange().rangeBitwiseAnd(1, 2));
    }
}
