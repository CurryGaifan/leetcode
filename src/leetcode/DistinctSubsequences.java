package leetcode;

/**
 * S = "rabbbit", T = "rabbit"
 * 
 * Return 3.
 * 
 * @author yanfeixiang
 * 
 */
public class DistinctSubsequences {
	public int numDistinct(String S, String T) {

		char[] s_a = S.toCharArray();
		char[] t_a = T.toCharArray();

		int[][] dp = new int[T.length() + 1][S.length() + 1];

		for (int i = 0; i < S.length() + 1; i++) {
			dp[0][i] = 1;
		}

		for (int i = 1; i < T.length() + 1; i++) {
			for (int j = i; j < S.length() + 1; j++) {
				if (t_a[i - 1] == s_a[j - 1]) {
					dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
				} else {
					dp[i][j] = dp[i][j - 1];
				}
			}
		}

		return dp[T.length()][S.length()];
	}

	public static void main(String[] args) {
		System.out.println(new DistinctSubsequences().numDistinct("rabbbit",
				"rabbit"));
	}
}
