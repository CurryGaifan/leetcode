package leetcode;

/**
 * Given s = "Hello World", return 5.
 * 
 * @author yanfeixiang
 * 
 */
public class LengthofLastWord {
	public int lengthOfLastWord(String s) {
		char[] c = s.toCharArray();
		int i = s.length() - 1;
		while (i >= 0 && c[i] == ' ')
			i--;

		for (int j = i; j >= 0; j--) {
			if (c[j] == ' ') {
				return i - j;
			}
		}
		return i + 1;
	}

	public static void main(String[] args) {
		System.out.println(new LengthofLastWord().lengthOfLastWord("H "));
	}
}