package leetcode.test;

import junit.framework.TestCase;
import leetcode.RegularExpressionMatching_DP;

import org.junit.Test;

/*
 * Some examples:
 isMatch("aa","a") ¡ú false
 isMatch("aa","aa") ¡ú true
 isMatch("aaa","aa") ¡ú false
 isMatch("aa", "a*") ¡ú true
 isMatch("aa", ".*") ¡ú true
 isMatch("ab", ".*") ¡ú true
 isMatch("aab", "c*a*b") ¡ú true
 */

public class Q10_test extends TestCase {

	RegularExpressionMatching_DP q = new RegularExpressionMatching_DP();

	@Test
	public void test1() {
		assertEquals(q.isMatch("aa", "a"), false);
	}

	@Test
	public void test2() {
		assertEquals(q.isMatch("aa", "aa"), true);
	}

	@Test
	public void test3() {
		assertEquals(q.isMatch("aaa", "aa"), false);
	}

	@Test
	public void test4() {
		assertEquals(q.isMatch("aa", "a*"), true);
	}

	@Test
	public void test5() {
		assertEquals(q.isMatch("aa", ".*"), true);
	}

	@Test
	public void test6() {
		assertEquals(q.isMatch("ab", ".*"), true);
	}

	@Test
	public void test7() {
		assertEquals(q.isMatch("aab", "c*a*b"), true);
	}

	@Test
	public void test8() {
		assertEquals(q.isMatch("aab", ".*b"), true);
	}

	@Test
	public void test9() {
		assertEquals(q.isMatch("baccbbcbcacacbbc", "c*.*b*c*ba*b*b*.a*"), true);
	}
}
