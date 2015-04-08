package leetcode;

/**
 *
 */
public class HouseRobber {
    public int rob(int[] num) {
        if (num.length == 0)
            return 0;
        int[] dp = new int[num.length];
        dp[0] = num[0];
        for (int i = 1; i < num.length; i++) {
            dp[i] = Math.max((i > 1 ? dp[i - 2] : 0) + num[i], dp[i - 1]);
        }
        return dp[dp.length - 1];

    }

    public static void main(String[] args) {
        System.out.println(new HouseRobber().rob(new int[]{1, 1, 1}));
    }
}
