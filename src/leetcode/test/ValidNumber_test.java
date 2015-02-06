package leetcode.test;

import junit.framework.TestCase;
import leetcode.ValidNumber;

import org.junit.Test;

public class ValidNumber_test extends TestCase {
	ValidNumber q = new ValidNumber();

	@Test
	public void test1() {
		assertTrue(q.isNumber("0"));
		assertTrue(q.isNumber("0.1"));
		assertFalse(q.isNumber("abc"));
		assertFalse(q.isNumber("1 a"));
		assertTrue(q.isNumber("2e10"));
		assertTrue(q.isNumber("2e10.0"));
		assertFalse(q.isNumber("2e10.1"));
		assertTrue(q.isNumber("-1.0"));
		assertTrue(q.isNumber("+1.0"));
		assertFalse(q.isNumber("e"));
		assertFalse(q.isNumber("."));
		assertTrue(q.isNumber("1 "));
		assertFalse(q.isNumber(" "));
		assertTrue(q.isNumber(".1"));
		assertFalse(q.isNumber("."));
		assertFalse(q.isNumber("2e"));
		assertFalse(q.isNumber("e2"));
		assertTrue(q.isNumber("01"));
		assertTrue(q.isNumber("1."));
		assertFalse(q.isNumber(".e1"));
		assertFalse(q.isNumber("1e."));
		assertTrue(q.isNumber("0e1"));
		assertFalse(q.isNumber(" -."));
		assertTrue(q.isNumber("46.e3"));
		assertFalse(q.isNumber("4e3."));
		assertTrue(q.isNumber("005047e+6"));
		assertTrue(q.isNumber("005047e-6"));
		assertFalse(q.isNumber("005047e-6."));
		assertTrue(q.isNumber("005047e-6.0"));
		assertFalse(q.isNumber("+++"));
		assertFalse(q.isNumber("---"));
		assertFalse(q.isNumber("4e+"));
	}

	@Test
	public void test2() {

	}

}
