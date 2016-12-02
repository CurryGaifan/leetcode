package leetcode;

/**
 * Created by yanfeixiang on 2016/9/26.
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * <p/>
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 */
public class PerfectSquares {
    public int numSquares(int n) {
        return numSquares(n, Integer.MAX_VALUE, 0);
    }

    public int numSquares(int n, int min, int cur) {
//        System.out.println(n + " " + min + " " + cur);

        if (n == 0)
            return cur;

        if (cur >= min) {
            return -1;
        }
        for (int i = (int) Math.floor(Math.sqrt(n)); i >= 1; i--) {
            int count = numSquares(n - (int) Math.pow(i, 2), min, cur + 1);
            if (count == -1)
                continue;
            min = Math.min(count, min);
        }

        return min;
    }

    public static void main(String[] args) {
        System.out.println(new PerfectSquares().numSquares(12));
        System.out.println(new PerfectSquares().numSquares(13));
        System.out.println(new PerfectSquares().numSquares(18));
    }

}
