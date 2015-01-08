package leetcode.test;

import junit.framework.TestCase;
import leetcode.IntegertoRoman;

import org.junit.Test;

public class Q12_test extends TestCase {

	IntegertoRoman q = new IntegertoRoman();

	@Test
	public void test1() {
		assertEquals(q.intToRoman(1), "I");
	}

	@Test
	public void test2() {
		assertEquals(q.intToRoman(2), "II");
	}

	@Test
	public void test3() {
		assertEquals(q.intToRoman(3), "III");
	}

	@Test
	public void test4() {
		assertEquals(q.intToRoman(4), "IV");
	}

	@Test
	public void test5() {
		assertEquals(q.intToRoman(5), "V");
	}

	@Test
	public void test6() {
		assertEquals(q.intToRoman(6), "VI");
	}

	@Test
	public void test7() {
		assertEquals(q.intToRoman(7), "VII");
	}

	@Test
	public void test8() {
		assertEquals(q.intToRoman(8), "VIII");
	}

	@Test
	public void test9() {
		assertEquals(q.intToRoman(9), "IX");
	}

	@Test
	public void test10() {
		assertEquals(q.intToRoman(10), "X");
	}
	
	@Test
	public void test11() {
		assertEquals(q.intToRoman(1899), "MDCCCXCIX");
	}
	
	@Test
	public void test12() {
		assertEquals(q.intToRoman(3999), "MMMCMXCIX");
	}
}
