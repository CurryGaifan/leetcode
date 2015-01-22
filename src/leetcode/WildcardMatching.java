package leetcode;

import util.PrintUtil;

/**
 * Some examples: isMatch("aa","a") → false isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false isMatch("aa", "*") → true isMatch("aa", "a*") →
 * true isMatch("ab", "?*") → true isMatch("aab", "c*a*b") → false
 * 
 * @author yanfeixiang
 * 
 */
public class WildcardMatching {
	public boolean isMatch(String s, String p) {
		char[] s_c = s.toCharArray();
		char[] p_c = p.toCharArray();

		int p_nstart_count = 0;
		for (char c : p_c) {
			if (c != '*')
				p_nstart_count++;
		}
		if (s.length() < p_nstart_count)//这个减枝太无聊了
			return false;

		Boolean[] p_dp = new Boolean[p.length() + 1];
		p_dp[0] = true;
		for (int i = 1; i < p.length() + 1; i++) {
			if (p_c[i - 1] == '*')
				p_dp[i] = p_dp[i - 1];
			else
				p_dp[i] = false;
		}

		// PrintUtil.printArray(p_dp);

		boolean s_matchEmpty = true;
		for (int j = 0; j < s.length(); j++) {
			if (s_c[j] != '*')
				s_matchEmpty = false;

			boolean tmp1 = s_matchEmpty;

			// System.out.println("b tmp1:" + tmp1);
			boolean tmp2;
			// System.out.println("s_c["+j+"]:" + s_c[j]);
			for (int i = 1; i < p.length() + 1; i++) {
				// System.out.println("tmp1:" + tmp1);
				// System.out.println("p_c["+(i - 1)+"]:" + p_c[i - 1]);
				if (p_c[i - 1] == '?') {
					tmp2 = p_dp[i - 1];
				} else if (p_c[i - 1] == '*') {
					tmp2 = p_dp[i - 1] || p_dp[i] || tmp1;
				} else if (p_c[i - 1] == s_c[j]) {
					tmp2 = p_dp[i - 1];
				} else
					tmp2 = false;

				p_dp[i - 1] = tmp1;
				tmp1 = tmp2;
			}
			p_dp[p_dp.length - 1] = tmp1;
			// PrintUtil.printArray(p_dp);
		}
		return p_dp[p_dp.length - 1];
	}

	public static void main(String[] args) {
		System.out.println(new WildcardMatching().isMatch("aaa", ""));
	}
}
