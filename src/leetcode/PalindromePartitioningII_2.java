package leetcode;

public class PalindromePartitioningII_2 {
	public int minCut(String s) {
		int[] mincuts = new int[s.length()];
		int length = 0;

		boolean[][] b = new boolean[s.length()][s.length()];
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < i; j++) {

				if (isPalind(s.substring(j, i + 1)))
					b[j][i] = true;
			}
		}

		if (s.length() == 0)
			return 0;
		int[] dp = new int[s.length()];
		dp[0] = 0;
		mincuts[0] = 0;
		for (int i = 1; i < s.length(); i++) {
			int min = dp[i - 1] + 1;
			for (int j = 0; j < i; j++) {
				// if (s.charAt(j) == s.charAt(i)
				// && (dp[j + 1] == dp[i - 1] || i - 1 == j))
				if (b[mincuts[j]][i]) {
					// System.out.println(mincuts[j]);
					min = Math.min(min, j > 0 ? (dp[j - 1] + 1) : 0);
				}

			}
			dp[i] = min;
			for (int k = i; k >= 0; k--) {
				if (dp[i] < dp[mincuts[k]]) {
					mincuts[k + 1] = mincuts[k];
				} else {
					mincuts[k] = i;
					break;
				}
			}
			// PrintUtil.printArray(dp);
		}
		return dp[dp.length - 1];

	}

	private boolean isPalind(String str) {

		int i = 0;
		int j = str.length() - 1;
		char[] ch = str.toCharArray();
		while (i < j) {
			if (ch[i] != ch[j]) {
				return false;
			}

			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out
				.println(new PalindromePartitioningII_2()
						.minCut("fifgbeajcacehiicccfecbfhhgfiiecdcjjffbghdidbhbdbfbfjccgbbdcjheccfbhafehieabbdfeigbiaggchaeghaijfbjhi"));
		System.out
				.println(new PalindromePartitioningII_2()
						.minCut("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
		System.out.println(new PalindromePartitioningII_2().minCut("saddsea"));
		System.out.println(new PalindromePartitioningII_2().minCut("bb"));
	}
}
