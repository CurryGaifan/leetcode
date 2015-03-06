package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * For example, given s = "leetcode", dict = ["leet", "code"].
 * 
 * Return true because "leetcode" can be segmented as "leet code".
 * 
 * @author yanfeixiang
 * 
 */
public class WordBreak {
	public boolean wordBreak(String s, Set<String> dict) {
		String[] strs = dict.toArray(new String[dict.size()]);
		for (String str1 : strs) {
			for (String str2 : strs) {
				dict.remove(str1 + str2);
				dict.remove(str2 + str1);
			}
		}

		return wordBreak(s, 0, dict);
	}

	public boolean wordBreak(String s, int i, Set<String> dict) {
		if (i == s.length())
			return true;
		for (int j = i + 1; j < s.length() + 1; j++) {
			if (dict.contains(s.subSequence(i, j))) {
				if (wordBreak(s, j, dict))
					return true;
			}
		}
		return false;

	}

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("a");
		set.add("aa");
		set.add("aaa");
		set.add("aaaa");
		set.add("aaaaa");
		set.add("aaaaaa");
		set.add("aaaaaaa");
		set.add("aaaaaaaa");
		set.add("aaaaaaaaa");
		set.add("aaaaaaaaaa");

		System.out
				.println(new WordBreak()
						.wordBreak(
								"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
								set));
	}
}
