package leetcode;

/*
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 
 * PAYPALISHIRING 
 * PYAIHRNAPLSIIG	2
 * PAHNAPLSIIGYIR	3
 * PINALSIGYAHRPI	4
 * 
 */
public class ZigZagConversion {
	public String convert(String s, int nRows) {
		if (nRows == 1)
			return s;
		int m = (s.length() / (2 * nRows - 2) + 1) * (nRows - 1);
		String[][] strs = new String[nRows][m];
		String tmp = "";
		for (int i = 0; i < s.length(); i++) {
			tmp = s.substring(i, i + 1);
			int x = i / (2 * nRows - 2);
			int y = i % (2 * nRows - 2);
			int r = y < nRows ? y : (2 * nRows - y - 1) - 1;
			int c = x * (nRows - 1) + (y < nRows ? 0 : y - nRows + 1);
			strs[r][c] = tmp;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < nRows; i++)
			for (int j = 0; j < m; j++) {
				if (strs[i][j] != null)
					sb.append(strs[i][j]);
			}

		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(new ZigZagConversion().convert("PAYPALISHIRING", 1));
	}
}
