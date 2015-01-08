package leetcode;

public class ReverseInteger {
	public int reverse(int x) {
		int y = x;
		if (y % 10 == 0)
			y /= 10;
		String str = String.valueOf(y);
		if (str.startsWith("-"))
			str = str.substring(1);
		char[] cs = str.toCharArray();
		for (int i = 0; i < (cs.length + 1) / 2; i++) {
			char tmp = cs[i];
			cs[i] = cs[cs.length - i - 1];
			cs[cs.length - i - 1] = tmp;
		}

		if (cs.length == 10 && cs[0] > '2') {
			return 0;
		} else if (cs.length == 10 && cs[0] == '2') {
			char[] cs_1 = new char[cs.length - 1];
			System.arraycopy(cs, 1, cs_1, 0, cs.length - 1);
			if (Integer.valueOf(new String(cs_1)) > Integer.MAX_VALUE % 1000000000)
				return 0;

		}
		y = Integer.valueOf(new String(cs));

		return x > 0 ? y : -y;
	}

	public static void main(String[] args) {
		System.out.println(new ReverseInteger().reverse(-2147483412));
	}
}
