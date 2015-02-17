package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * 
 * The number of ways decoding "12" is 2.
 * 
 * @author yanfeixiang
 * 
 */
public class DecodeWays_2 {

	public int numDecodings(String s) {

		if (s.length() == 0)
			return 0;
		if (s.startsWith("0"))
			return 0;

		if (s.length() == 1)
			return 1;

		int[] dp = new int[s.length() + 1];
		dp[s.length()] = 1;
		dp[s.length() - 1] = s.substring(s.length() - 1).equals("0") ? 0 : 1;
		for (int i = s.length() - 2; i >= 0; i--) {
			if (s.charAt(i) == '0')
				dp[i] = 0;
			else {
				int count = Integer.valueOf(s.substring(i, i + 2));
				if (count >= 10 && count <= 26) {
					dp[i] = dp[i + 1] + dp[i + 2];
				} else {
					dp[i] = dp[i + 1];
				}
			}

		}
		return dp[0];
	}

	public static void main(String[] args) {
		System.out.println(new DecodeWays_2().numDecodings("123123123123"));
	}
}
