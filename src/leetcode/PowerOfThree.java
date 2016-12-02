package leetcode;

/**
 * Created by yanfeixiang on 2016/9/21.
 * <p/>
 * Given an integer, write a function to determine if it is a power of three.
 * <p/>
 * Follow up:
 * Could you do it without using any loop / recursion?
 * <p/>
 * <p/>
 * https://discuss.leetcode.com/topic/36150/1-line-java-solution-without-loop-recursion
 */
public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        return (n > 0 && 1162261467 % n == 0);
    }
}
