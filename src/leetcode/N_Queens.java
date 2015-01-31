package leetcode;

import java.util.ArrayList;
import java.util.List;

import util.PrintUtil;

/**
 * [ [".Q..", "...Q", "Q...", "..Q."],
 * 
 * ["..Q.", "Q...", "...Q", ".Q.."] ]
 * 
 * @author yanfeixiang
 * 
 */
public class N_Queens {
	public List<String[]> solveNQueens(int n) {
		List<String[]> result = new ArrayList<String[]>();
		char[][] c = new char[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				c[i][j] = '.';
		solve(result, c, 0, 0);

		return result;
	}

	private void solve(List<String[]> list, char[][] c, int i, int j) {
		if (i == c.length) {
			String[] strs = new String[c.length];
			for (int m = 0; m < c.length; m++) {
				strs[m] = new String(c[m]);

			}
			list.add(strs);
			return;
		}

		while ((j = findN(c, i, j)) != -1) {
			c[i][j] = 'Q';
			solve(list, c, i + 1, 0);
			c[i][j] = '.';
			j++;
		}

	}

	private int findN(char[][] c, int i, int j) {
		for (int m = j; m < c.length; m++) {
			if (canadd(c, i, m)) {
				return m;
			}
		}
		return -1;
	}

	private boolean canadd(char[][] c, int i, int j) {
		for (int m = 0; m < c.length; m++) {
			if (j != m && c[i][m] == 'Q')
				return false;
			if (i != m && c[m][j] == 'Q')
				return false;
		}
		int x = i;
		int y = j;
		while (x >= 0 && y >= 0) {
			if (c[x][y] == 'Q')
				return false;
			x--;
			y--;
		}

		x = i;
		y = j;
		while (x < c.length && y < c.length) {
			if (c[x][y] == 'Q')
				return false;
			x++;
			y++;
		}

		x = i;
		y = j;
		while (x >= 0 && x < c.length && y >= 0 && y < c.length) {
			if (c[x][y] == 'Q')
				return false;
			x--;
			y++;
		}

		x = i;
		y = j;
		while (x >= 0 && x < c.length && y >= 0 && y < c.length) {
			if (c[x][y] == 'Q')
				return false;
			x++;
			y--;
		}

		return true;

	}

	public static void main(String[] args) {
		List<String[]> list = new N_Queens().solveNQueens(7);
		for (String[] strs : list) {
			PrintUtil.printArray(strs);
		}
	}
}
