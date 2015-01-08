package leetcode;

/*
 * Some examples:
 isMatch("aa","a") ¡ú false
 isMatch("aa","aa") ¡ú true
 isMatch("aaa","aa") ¡ú false
 isMatch("aa", "a*") ¡ú true
 isMatch("aa", ".*") ¡ú true
 isMatch("ab", ".*") ¡ú true
 isMatch("aab", "c*a*b") ¡ú true
 */
public class RegularExpressionMatching_DP {
	public boolean isMatch(String s, String p) {
		char[] array_s = s.toCharArray();
		char[] array_p = p.toCharArray();

		boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
		dp[0][0] = true;
		for (int i = 1; i < dp.length; i++)
			if (array_s[i - 1] == '*')
				dp[i][0] = dp[i - 2][0];

		for (int i = 1; i < dp[0].length; i++)
			if (array_p[i - 1] == '*')
				dp[0][i] = dp[0][i - 2];

		for (int i = 1; i < dp.length; i++)
			for (int j = 1; j < dp[0].length; j++) {
				if (array_s[i - 1] == '.' || array_p[j - 1] == '.') {
					dp[i][j] = dp[i - 1][j - 1];
				} else if (array_s[i - 1] == '*') {
					dp[i][j] = dp[i - 1][j] || dp[i - 2][j];
				} else if (array_p[j - 1] == '*') {
					dp[i][j] = dp[i][j - 1]
							|| dp[i][j - 2]
							|| (dp[i - 1][j] && (array_s[i - 1] == array_p[j - 2] || array_p[j - 2] == '.'));
				} else {
					dp[i][j] = dp[i - 1][j - 1]
							&& array_s[i - 1] == array_p[j - 1];
				}
			}
		return dp[s.length()][p.length()];
	}

	public static void main(String[] args) {
		System.out.println(new RegularExpressionMatching_DP().isMatch("baccbbcbcacacbbc",
				"c*.*b*c*ba*b*b*.a*"));
	}
}
