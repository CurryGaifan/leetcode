package leetcode.test;

import junit.framework.TestCase;
import leetcode.DivideTwoIntegers;

import org.junit.Test;

public class DivideTwoIntegers_test extends TestCase {
	DivideTwoIntegers q = new DivideTwoIntegers();

	@Test
	public void test1() {
		assertEquals(q.divide(1, 1), 1);
	}

	@Test
	public void test2() {
		assertEquals(q.divide(9, 0), Integer.MAX_VALUE);
		assertEquals(q.divide(9, 1), 9);
		assertEquals(q.divide(9, 2), 4);
		assertEquals(q.divide(9, 3), 3);
		assertEquals(q.divide(9, 4), 2);
		assertEquals(q.divide(9, 5), 1);
		assertEquals(q.divide(9, 6), 1);
		assertEquals(q.divide(9, 7), 1);
		assertEquals(q.divide(9, 8), 1);
		assertEquals(q.divide(9, 9), 1);
		assertEquals(q.divide(9, 10), 0);
	}

	@Test
	public void test3() {
		assertEquals(q.divide(Integer.MAX_VALUE, 2), Integer.MAX_VALUE / 2);
		assertEquals(q.divide(Integer.MIN_VALUE, 2), Integer.MIN_VALUE / 2);
		assertEquals(q.divide(Integer.MIN_VALUE, Integer.MIN_VALUE),
				Integer.MIN_VALUE / Integer.MIN_VALUE);
		assertEquals(q.divide(Integer.MAX_VALUE, Integer.MAX_VALUE),
				Integer.MAX_VALUE / Integer.MAX_VALUE);
		assertEquals(q.divide(Integer.MAX_VALUE, Integer.MIN_VALUE),
				Integer.MAX_VALUE / Integer.MIN_VALUE);
		assertEquals(q.divide(Integer.MIN_VALUE, Integer.MAX_VALUE),
				Integer.MIN_VALUE / Integer.MAX_VALUE);

		assertEquals(q.divide(Integer.MIN_VALUE, -1), Integer.MAX_VALUE);
	}
}
