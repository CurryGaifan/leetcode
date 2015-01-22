package leetcode.test;

import junit.framework.TestCase;
import leetcode.MultiplyStrings_2;

import org.junit.Test;

public class MultiplyStrings_test extends TestCase {
	MultiplyStrings_2 q = new MultiplyStrings_2();

	@Test
	public void test1() {
		assertEquals(String.valueOf(0 * 0), q.multiply("0", "0"));
		assertEquals(String.valueOf(0 * 1), q.multiply("0", "1"));
		assertEquals(String.valueOf(1 * 0), q.multiply("1", "0"));
		assertEquals(String.valueOf(11 * 0), q.multiply("11", "0"));
	}

	@Test
	public void test2() {
		assertEquals(String.valueOf(1 * 1), q.multiply("1", "1"));
		assertEquals(String.valueOf(1 * 222), q.multiply("1", "222"));
		assertEquals(String.valueOf(222 * 1), q.multiply("222", "1"));
		assertEquals(String.valueOf(101 * 1), q.multiply("101", "1"));
	}

	@Test
	public void test3() {
		// assertEquals(String.valueOf(11 * 11), q.multiply("11", "11"));
		assertEquals(String.valueOf((long) Integer.MAX_VALUE * 3),
				q.multiply(String.valueOf(Integer.MAX_VALUE), "3"));

		assertEquals(String.valueOf((long) 123456789 * (long) 987654321),
				q.multiply("123456789", "987654321"));
	}

}
