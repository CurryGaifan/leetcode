package leetcode.test;

import junit.framework.TestCase;
import leetcode.RomantoInteger;

import org.junit.Test;

public class Q13_test extends TestCase {

	RomantoInteger q = new RomantoInteger();

	@Test
	public void test1() {
		assertEquals(q.romanToInt("I"), 1);
	}

	@Test
	public void test2() {
		assertEquals(q.romanToInt("II"), 2);
	}

	@Test
	public void test3() {
		assertEquals(q.romanToInt("III"), 3);
	}

	@Test
	public void test4() {
		assertEquals(q.romanToInt("IV"), 4);
	}

	@Test
	public void test5() {
		assertEquals(q.romanToInt("V"), 5);
	}

	@Test
	public void test6() {
		assertEquals(q.romanToInt("VI"), 6);
	}

	@Test
	public void test7() {
		assertEquals(q.romanToInt("VII"), 7);
	}

	@Test
	public void test8() {
		assertEquals(q.romanToInt("VIII"), 8);
	}

	@Test
	public void test9() {
		assertEquals(q.romanToInt("IX"), 9);
	}

	@Test
	public void test10() {
		assertEquals(q.romanToInt("X"), 10);
	}

	@Test
	public void test11() {
		assertEquals(q.romanToInt("MDCCCXCIX"), 1899);
	}

	@Test
	public void test12() {
		assertEquals(q.romanToInt("MMMCMXCIX"), 3999);
	}
}
