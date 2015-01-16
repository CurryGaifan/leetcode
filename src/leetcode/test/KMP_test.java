package leetcode.test;

import junit.framework.TestCase;
import leetcode.ImplementstrStr_KMP;

import org.junit.Test;

public class KMP_test extends TestCase {
	ImplementstrStr_KMP q = new ImplementstrStr_KMP();

	@Test
	public void test1() {
		assertEquals(q.strStr("abcabcdfefabcdef", "abcde"), 10);
	}

	@Test
	public void test2() {
		assertEquals(q.strStr("ababc", "abc"), 2);
	}

	@Test
	public void test3() {
		assertEquals(q.strStr("abababc", "abc"), 4);
	}

	@Test
	public void test4() {
		assertEquals(q.strStr("abababc", ""), 0);
	}

	@Test
	public void test5() {
		assertEquals(q.strStr("aaa", "aaaa"), -1);
	}
}
