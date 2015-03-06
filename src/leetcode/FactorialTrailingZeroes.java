package leetcode;

public class FactorialTrailingZeroes {
	public int trailingZeroes(int n) {
		int ret = 0;
		while (n != 0) {
			ret += n / 5;
			n /= 5;
		}
		return ret;
	}

	public static void main(String[] args) {
		System.out.println(new FactorialTrailingZeroes().trailingZeroes(99));
	}
}
