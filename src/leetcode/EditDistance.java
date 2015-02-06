package leetcode;

import util.PrintUtil;

/**
 * a) Insert a character b) Delete a character c) Replace a character
 * 
 * @author yanfeixiang
 * 
 */
public class EditDistance {
	public int minDistance(String word1, String word2) {
		char[] w1 = word1.toCharArray();
		char[] w2 = word2.toCharArray();

		int difSteps = getMin(w1.length, w2.length, w1, w2, 0, 0);
		// return Math.min(difSteps, Math.max(word1.length(), word2.length()));

		return difSteps;
	}

	private int getMin(int i, int j, char[] w1, char[] w2, int xStep, int yStep) {
		if (j == 0 && i == 0)
			return Math.max(xStep, yStep);

		if (i > 0 && j > 0 && w1[i - 1] == w2[j - 1]) {

			return Math.max(xStep, yStep)
					+ Math.min(getMin(i - 1, j - 1, w1, w2, 0, 0),
							Math.max(i - 1, j - 1));
		} else {
			if (j == 0) {
				return getMin(i - 1, j, w1, w2, xStep + 1, yStep);
			} else if (i == 0) {
				return getMin(i, j - 1, w1, w2, xStep, yStep + 1);
			} else {
				return Math.min(Math.min(
						getMin(i - 1, j, w1, w2, xStep + 1, yStep),
						getMin(i, j - 1, w1, w2, xStep, yStep + 1)),
						getMin(i - 1, j - 1, w1, w2, xStep + 1, yStep + 1));
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(new EditDistance().minDistance("", "a"));
	}
}
