package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * s1 = "aabcc", s2 = "dbbca",
 * 
 * When s3 = "aadbbcbcac", return true.
 * 
 * When s3 = "aadbbbaccc", return false.
 * 
 * @author yanfeixiang
 * 
 */
public class InterleavingString {
	static Set<String> set = new HashSet<String>();

	public boolean isInterleave(String s1, String s2, String s3) {
		return isContainsS2(s1, s2, s3);
	}

	private boolean isContainsS2(String s1_suffix, String s2_suffix,
			String s3_suffix) {
		if (set.contains(s1_suffix + " " + s2_suffix + " " + s3_suffix))
			return false;

		if (s1_suffix.length() + s2_suffix.length() != s3_suffix.length()) {
			set.add(s1_suffix + " " + s2_suffix + " " + s3_suffix);
			return false;
		}

		if (s1_suffix.length() == 0)
			return s2_suffix.equals(s3_suffix);

		if (s2_suffix.length() == 0)
			return s1_suffix.equals(s3_suffix);

		char s1_c = s1_suffix.charAt(0);
		for (int i = 0; i < s3_suffix.length(); i++) {
			if (s3_suffix.charAt(i) == s1_c) {
				if (s2_suffix.startsWith(s3_suffix.substring(0, i))) {
					if (isContainsS2(s1_suffix.substring(1),
							s2_suffix.substring(i), s3_suffix.substring(i + 1)))
						return true;
				}
			}
		}
		set.add(s1_suffix + " " + s2_suffix + " " + s3_suffix);
		return false;

	}

	public static void main(String[] args) {
		System.out
				.println(new InterleavingString()
						.isInterleave(
								"bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa",
								"babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab",
								"babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab"));
	}
}
