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
public class ZigZagConversion_2 {
	public String convert(String s, int nRows) {
		if (nRows == 1)
			return s;
		StringBuilder sb = new StringBuilder();
		int num = nRows * 2 - 2;
		int index = 0;
		for (int j = num; j > -1 && index < nRows; j -= 2) {
			int tmp = index;

			for (int times = 0; tmp < s.length(); tmp += (times % 2 == 0 ? num
					- j : j)) {
				if ((times % 2 == 0 ? j : num - j) != 0)
					sb.append(s.substring(tmp, tmp + 1));
				times++;
			}
			index++;
		}
		return sb.toString();
	}

	public static void main(String[] args) {

		System.out.println(new ZigZagConversion_2().convert("PAYPALISHIRING", 1));
	}
}
