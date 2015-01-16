package leetcode;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		Set<Character> set1 = new HashSet<Character>();

		Set<Character> set2 = new HashSet<Character>();
		for (int j = 0; j < board.length; j++) {
			set1.clear();
			set2.clear();
			for (int i = 0; i < board.length; i++) {

				if (board[j][i] != '.') {
					if (set1.contains(board[j][i])) {
						return false;
					} else
						set1.add(board[j][i]);
				}

				if (board[i][j] != '.') {
					if (set2.contains(board[i][j])) {
						return false;
					} else
						set2.add(board[i][j]);
				}
			}

		}
		for (int i = 0; i < board.length; i++) {
			set1.clear();
			for (int j = i / 3 * 3; j < i / 3 * 3 + 3; j++) {
				for (int k = (i % 3) * 3; k < (i % 3) * 3 + 3; k++) {

					if (board[j][k] != '.') {
						if (set1.contains(board[j][k])) {
							return false;
						} else
							set1.add(board[j][k]);
					}
				}
			}
		}
		return true;
	}
}
