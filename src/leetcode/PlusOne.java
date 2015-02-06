package leetcode;

import util.PrintUtil;

public class PlusOne {
	public int[] plusOne(int[] digits) {

		int add = 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			int tmp = digits[i];
			digits[i] = (add + digits[i]) % 10;
			add = (add + tmp) / 10;
		}
		if (add == 1) {
			int[] _digits = new int[digits.length + 1];
			_digits[0] = 1;
			System.arraycopy(digits, 0, _digits, 1, digits.length);
			digits = _digits;
		}
		return digits;
	}

	public static void main(String[] args) {
		PrintUtil.printArray(new PlusOne().plusOne(new int[] { 0 }));
	}
}
