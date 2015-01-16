package leetcode;

import java.util.HashSet;
import java.util.Set;

import util.PrintUtil;

public class SudokuSolver {
	public void solveSudoku(char[][] board) {
		helper(board, 0, 0);
	}

	boolean helper(char[][] board, int i, int j) {
		// find next null;
		// System.out.println("i:" + i + ",j:" + j);
		boolean find = false;

		for (int k = j ; k < 9 && !find; k++)
			if (board[i][k] == '.') {
				j = k;
				// System.out.println("j:" + j);
				find = true;
			}

		for (int m = i + 1; m < 9 && !find; m++) {
			for (int n = 0; n < 9 && !find; n++) {
				if (board[m][n] == '.') {
					i = m;
					j = n;

					find = true;
					break;
				}
			}
			if (find)
				break;
		}

		if (!find)
			return true;

		for (int k = 1; k < 10; k++) {
			if (valid(board, i, j, k)) {
				board[i][j] = (char) ('0' + k);
				if (helper(board, i, j))
					return true;
				else
					board[i][j] = '.';
			}
		}
		return false;
	}

	private boolean valid(char[][] board, int i, int j, int k) {
		Set<Character> set1 = new HashSet<Character>();
		Set<Character> set2 = new HashSet<Character>();
		set1.add((char) ('0' + k));
		set2.add((char) ('0' + k));
		for (int l = 0; l < 9; l++) {
			if (board[i][l] != '.')
				if (set1.contains(board[i][l]))
					return false;
				else
					set1.add(board[i][l]);

			if (board[l][j] != '.')
				if (set2.contains(board[l][j]))
					return false;
				else
					set2.add(board[l][j]);

		}
		set1.clear();
		set1.add((char) ('0' + k));

		for (int m = i / 3 * 3; m < i / 3 * 3 + 3; m++) {
			for (int n = j / 3 * 3; n < j / 3 * 3 + 3; n++) {
				if (board[m][n] != '.')
					if (set1.contains(board[m][n]))
						return false;
					else
						set1.add(board[m][n]);
			}
		}

		return true;
	}

	public static void main(String[] args) {
		char[][] chars = new char[][] {
				{ '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' },
				{ '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' },
				{ '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' },
				{ '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' },
				{ '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		new SudokuSolver().solveSudoku(chars);
		for (int i = 0; i < chars.length; i++) {
			PrintUtil.printArray(chars[i]);
		}
	}
}
