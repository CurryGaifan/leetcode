package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LetterCombinationsofaPhoneNumber {
	private static String[][] strs = new String[][] { { "a", "b", "c" },
			{ "d", "e", "f" }, { "g", "h", "i" }, { "j", "k", "l" },
			{ "m", "n", "o" }, { "p", "q", "r", "s" }, { "t", "u", "v" },
			{ "w", "x", "y", "z" }, { " " } };

	public List<String> letterCombinations(String digits) {

		ArrayList<String> list = new ArrayList<String>((int) (Math.pow(3,
				digits.length())));
		if (digits.equals("")) {
			list.add("");
			return list;
		}

		ArrayList<String> tmp = null;
		char[] chars = digits.toCharArray();
		for (int i = 0; i < digits.length(); i++) {
			char c = chars[i];
			tmp = (ArrayList) list.clone();
			list.clear();

			for (String endfix : strs[c == '0' ? 8 : c - '2']) {
				if (tmp.size() == 0)
					list.add(endfix);
				else
					for (String str : tmp) {
						list.add(str + endfix);
					}
			}
		}
		return list;

	}

	public static void main(String[] args) {
		List<String> list = new LetterCombinationsofaPhoneNumber().letterCombinations("5");
		for (String str : list) {
			System.out.print(str + " ");
		}
	}
}
