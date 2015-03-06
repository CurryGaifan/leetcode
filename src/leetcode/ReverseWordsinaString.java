package leetcode;

/**
 * Given s = "the sky is blue",
 * 
 * return "blue is sky the".
 * 
 * @author yanfeixiang
 * 
 */

public class ReverseWordsinaString {
	public String reverseWords(String s) {
		if (s == null)
			return null;
		s = s.trim();
		if (s.length() == 0)
			return s;
		String str = "";
		String[] strs = s.split(" ");
		for (String sub : strs) {
			if (sub.length() == 0)
				continue;
			str += reverseWord(sub) + " ";
		}
		return reverseWord(str.substring(0, str.length() - 1));
	}

	public String reverseWord(String s) {
		char[] s_c = s.toCharArray();

		int i = 0;
		int j = s.length() - 1;

		while (i <= j) {
			char tmp = s_c[i];
			s_c[i] = s_c[j];
			s_c[j] = tmp;
			i++;
			j--;
		}
		return new String(s_c);
	}

	public static void main(String[] args) {
		System.out.println(new ReverseWordsinaString().reverseWords(" "));
	}
}
