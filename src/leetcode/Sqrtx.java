package leetcode;

public class Sqrtx {
	public int sqrt(int x) {
		if (x == 0)
			return 0;
		long y = x;
		long k = 1;
		while (k * k != y && !(y - k * k > 0 && (k + 1) * (k + 1) - y > 0)) {
			k = (k + y / k) / 2;
		}
		return (int) k;
	}

	public static void main(String[] args) {
		System.out.println(new Sqrtx().sqrt(2147483647));
	}
}
