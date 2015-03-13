package leetcode.test;

import junit.framework.TestCase;
import leetcode.FractiontoRecurringDecimal;

import org.junit.Test;

public class FractiontoRecurringDecimal_test extends TestCase {

	FractiontoRecurringDecimal q = new FractiontoRecurringDecimal();

	@Test
	public void test1() {
		assertEquals(q.fractionToDecimal(-5, 7), "-0.(714285)");
		assertEquals(q.fractionToDecimal(-2147483648, 1), "-2147483648");
		assertEquals(q.fractionToDecimal(-2147483648, -2), "" + -2147483648
				/ -2);
		assertEquals(q.fractionToDecimal(-2147483648, -2147483648), "1");
		assertEquals(-1d / -2147483648d, "0.0000000004656612873077392578125");
		assertEquals(q.fractionToDecimal(-1, -2147483648),
				"0.0000000004656612873077392578125");
	}

	// public static void main(String[] args) {
	// System.out.println(-Integer.MIN_VALUE);
	// System.out.println(-Integer.MAX_VALUE);
	// System.out.println(-2147483648 * 0.0000000004656612873077392578125);
	// System.out.println(-1f / -2147483648f);
	// }
}
