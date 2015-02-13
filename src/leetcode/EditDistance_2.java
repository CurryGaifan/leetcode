package leetcode;

import util.PrintUtil;

/**
 * a) Insert a character b) Delete a character c) Replace a character
 * 
 * @author yanfeixiang
 * 
 */
public class EditDistance_2 {
	public int minDistance(String word1, String word2) {
		char[] w1 = word1.toCharArray();
		char[] w2 = word2.toCharArray();

		int[][] dp = new int[word1.length() + 1][word2.length() + 1];

		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = i;
		}

		for (int j = 0; j < dp[0].length; j++) {
			dp[0][j] = j;
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				// System.out.println(i + " " + j);
				if (w1[i - 1] == w2[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]),
							dp[i - 1][j - 1]) + 1;
				}
			}
		}

		return dp[word1.length()][w2.length];
	}

	public static void main(String[] args) {
		System.out.println(new EditDistance_2().minDistance("", "a"));
	}
}
