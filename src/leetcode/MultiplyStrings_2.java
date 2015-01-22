package leetcode;

public class MultiplyStrings_2 {
	public String multiply(String num1, String num2) {
		String result = "0";
		for (int i = num1.length() - 1; i > -1;) {
			String tmp = "0";
			int i_next = i > 3 ? i - 4 : -1;
			// System.out.println("i_next: " + i_next);
			for (int j = num2.length() - 1; j > -1;) {

				int j_next = j > 3 ? j - 4 : -1;
				// System.out.println("j_next: " + j_next);
				tmp = add(
						tmp,
						subInt(num1.substring(i_next + 1, i + 1),
								num2.substring(j_next + 1, j + 1)),
						num2.length() - j - 1);
				j = j_next;
			}

			result = add(result, tmp, num1.length() - 1 - i);
			i = i_next;
		}

		return result;
	}

	private String subInt(String num1, String num2) {
		return String.valueOf(Integer.valueOf(num1) * Integer.valueOf(num2));
	}

	private String add(String num1, String num2, int index) {

		// System.out
		// .println("num1:" + num1 + ",num2:" + num2 + ",index:" + index);
		if (num1.equals("0"))
			return num2;

		for (int i = 0; i < index; i++)
			num2 += "0";
		int i = num1.length() - 1;
		int j = num2.length() - 1;
		String sum = "";
		int added = 0;

		while (i > -1 || j > -1) {
			int add1 = 0;
			int add2 = 0;
			if (i > -1)
				add1 = Integer.valueOf(num1.substring(i, i + 1));

			if (j > -1)
				add2 = Integer.valueOf(num2.substring(j, j + 1));
			// System.out.println("add1:" + add1 + ", add2:" + add2 + ",added:"
			// + added);
			sum = String.valueOf((added + add1 + add2) % 10) + sum;
			added = (add1 + add2 + added) / 10;
			i--;
			j--;
		}
		if (added == 1)
			sum = "1" + sum;
		// System.out.println("sum:" + sum);
		return sum;
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println(new MultiplyStrings_2().multiply("123456789",
				"987654321"));
		long end = System.currentTimeMillis();
		System.out.println(end - start);

	}
}
