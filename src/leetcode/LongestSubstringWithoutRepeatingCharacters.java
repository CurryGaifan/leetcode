package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();

		int minIndex = 0;
		int length = 0;
		int tmplength = 0;

		int index;
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (map.containsKey(chars[i])
					&& (index = map.get(chars[i])) >= minIndex) {

				length = Math.max(length, tmplength);
				tmplength = i - index;
				minIndex = index + 1;
			} else {
				tmplength++;
			}

			map.put(chars[i], i);
		}
		return Math.max(length, tmplength);

	}

	public static void main(String[] args) {
		System.out.println(new LongestSubstringWithoutRepeatingCharacters()
				.lengthOfLongestSubstring("123123412345hhhhhhh1234567"));
	}
}
