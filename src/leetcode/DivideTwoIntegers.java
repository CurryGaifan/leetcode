package leetcode;

public class DivideTwoIntegers {

	int result;
	boolean add1;

	public int divide(int dividend, int divisor) {

		// System.out.println("===============");
		if (divisor == 0)
			return Integer.MAX_VALUE;

		if (divisor == Integer.MIN_VALUE) {
			if (dividend == Integer.MIN_VALUE)
				return 1;
			else
				return 0;
		}

		if (dividend == Integer.MIN_VALUE) {
			if (Math.abs(divisor) >= -(dividend / 2))
				return divisor > 0 ? -1 : 1;
			else if (divisor == -1)
				return Integer.MAX_VALUE;
			else {
				add1 = true;
				dividend += 1;
			}
		}

		int _dividend = dividend;
		if (_dividend < 0)
			_dividend = -_dividend;

		int _divisor = divisor;
		if (_divisor < 0)
			_divisor = -_divisor;
		result = 0;

		_divide(_dividend, _divisor);

		if (dividend > 0 && divisor > 0)
			return result;
		else if (dividend < 0 && divisor < 0)
			return result;
		else
			return -result;
	}

	public int _divide(int dividend, int divisor) {

		// System.out.println("dividend: " + dividend + ", divisor:" + divisor);
		if (dividend >= divisor) {
			int add = 0;
			if (add1) {
				add = 1;
				add1 = false;
			}

			int div = _divide(dividend >> 1, divisor);

			// System.out.println("div:" + div + ", add: " + add);
			if (dividend - (div << 1) + add == divisor + divisor) {

				result = (result << 1) + 2;
				// System.out.println("result1: " + result);
				// System.out.println("return: "
				// + ((div << 1) + divisor + divisor));
				return (div << 1) + divisor;
			} else if (dividend - (div << 1) + add >= divisor) {

				result = (result << 1) + 1;
				// System.out.println("result1: " + result);
				// System.out.println("return: " + ((div << 1) + divisor));
				return (div << 1) + divisor;
			} else {
				result = result << 1;
				// System.out.println("result2: " + result);
				// System.out.println("return: " + (div << 1));
				return div << 1;
			}

		} else {
			return 0;
		}
	}

	public static void main(String[] args) {
		System.out.println(new DivideTwoIntegers().divide(8, 3));
		System.out.println(-Integer.MIN_VALUE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Math.abs(Integer.MIN_VALUE));
		System.out.println(-8 >> 5);
	}
}
