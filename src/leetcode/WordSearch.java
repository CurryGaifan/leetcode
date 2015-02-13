package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * [ ["ABCE"], ["SFCS"], ["ADEE"] ] word = "ABCCED", -> returns true, word =
 * "SEE", -> returns true, word = "ABCB", -> returns false.
 * 
 * @author yanfeixiang
 * 
 */
public class WordSearch {
	public boolean exist(char[][] board, String word) {
		Set<String> set = new HashSet<String>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					if (canGo(board, i, j, set, word, 0))
						return true;
				}
			}
		}
		return false;
	}

	boolean canGo(char[][] board, int i, int j, Set<String> set, String word,
			int index) {
		if (index == word.length())
			return true;
		if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1
				|| set.contains(i + "_" + j)
				|| board[i][j] != word.charAt(index))
			return false;

		set.add(i + "_" + j);

		if (canGo(board, i + 1, j, set, word, index + 1))
			return true;
		if (canGo(board, i - 1, j, set, word, index + 1))
			return true;
		if (canGo(board, i, j - 1, set, word, index + 1))
			return true;
		if (canGo(board, i, j + 1, set, word, index + 1))
			return true;

		set.remove(i + "_" + j);
		return false;

	}

	public static void main(String[] args) {
		System.out.println(new WordSearch().exist(new char[][] { { 'a' } },
				"ab"));
	}
}
