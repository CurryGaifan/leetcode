package leetcode;

public class PalindromePartitioningII {
	public int minCut(String s) {

		if (isPalind(s))
			return 0;
		int mincut = Integer.MAX_VALUE;

		for (int i = 0; i < s.length(); i++) {
			if (isPalind(s.substring(0, i + 1))) {

				mincut = Math.min(mincut, minCut(s.substring(i + 1)));

			}
		}
		return mincut + 1;
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
		// System.out
		// .println(new PalindromePartitioningII()
		// .minCut("fifgbeajcacehiicccfecbfhhgfiiecdcjjffbghdidbhbdbfbfjccgbbdcjheccfbhafehieabbdfeigbiaggchaeghaijfbjhi"));
		System.out
				.println(new PalindromePartitioningII()
						.minCut("saddsea"));

	}
}
