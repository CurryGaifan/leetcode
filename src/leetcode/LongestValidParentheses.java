package leetcode;

import java.util.Stack;

import util.PrintUtil;

public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
		char[] c = s.toCharArray();
		int[] r_index = new int[s.length()];
		Stack<Integer> l_index = new Stack<Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (c[i] == '(') {
				l_index.push(i);
			} else {
				if (l_index.size() != 0) {
					r_index[l_index.pop()] = i;
				}
			}
		}
		int maxLength = 0;
		for (int i = 0; i < r_index.length; i++) {
			int length = 0;
			int j = i;
			while (j < r_index.length && r_index[j] != 0) {
				length += r_index[j] - j + 1;
				j = r_index[j] + 1;
			}
			maxLength = Math.max(maxLength, length);
		}

		return maxLength;
	}

	public static void main(String[] args) {
		System.out.println(new LongestValidParentheses()
				.longestValidParentheses("((()())(()()))"));
	}
}
