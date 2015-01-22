package leetcode;

public class MultiplyStrings {
	public String multiply(String num1, String num2) {
		String result = "0";
		for (int i = num1.length() - 1; i > -1; i--) {
			String tmp = "0";
			for (int j = num2.length() - 1; j > -1; j--) {
				tmp = add(
						tmp,
						subInt(num1.substring(i, i + 1),
								num2.substring(j, j + 1)), num2.length() - j
								- 1);
			}

			result = add(result, tmp, num1.length() - 1 - i);
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

			sum = String.valueOf((added + (add1 + add2) % 10)) + sum;
			added = (add1 + add2) / 10;
			i--;
			j--;
		}
		if (added == 1)
			sum = "1" + sum;
		// System.out.println("sum:" + sum);
		return sum;
	}

	public static void main(String[] args) {
		System.out
				.println(new MultiplyStrings()
						.multiply(
								"63068080726329880611684115603801120940144776974937025638198670884099005492080675397052881650850279",
								"91851171339080006286661648785824201538663791893631297"));

	}
}
