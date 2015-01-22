package leetcode;

public class Pow_x_n {
	public double pow(double x, int n) {
		double result = 1;

		if (Math.abs(x) > 1) {
			for (int i = 0; i < Math.abs(n); i++) {
				result *= x;
			}
		} else if (x == 1) {
			result = 1;
		} else if (x == -1) {
			if (n % 2 == 0)
				result = 1;
			else
				result = -1;
		} else {
			for (int i = 0; i < Math.abs(n); i++) {
				result *= x;
				if (result == 0)
					break;
			}
		}

		if (n < 0) {
			result = 1 / result;
		}

		return result;

	}

	public static void main(String[] args) {
		System.out.println(new Pow_x_n().pow(3, 3));
		System.out.println(new Pow_x_n().pow(3, 0));
		System.out.println(new Pow_x_n().pow(3, -3));
		System.out.println(new Pow_x_n().pow(0.00001, 2147483647));
		System.out.println(new Pow_x_n().pow(1.00000, 2147483647));
	}

}
