package leetcode.test;

import junit.framework.TestCase;
import leetcode.LongestValidParentheses;

import org.junit.Test;

public class LongestValidParentheses_test extends TestCase {

	LongestValidParentheses q = new LongestValidParentheses();

	@Test
	public void test1() {
		assertEquals(2, q.longestValidParentheses("()(()"));
	}

	@Test
	public void test2() {
		assertEquals(2, q.longestValidParentheses("(()"));
	}

	@Test
	public void test3() {
		assertEquals(4, q.longestValidParentheses(")()())"));
	}

	@Test
	public void test4() {
		assertEquals(0, q.longestValidParentheses(""));
		assertEquals(0, q.longestValidParentheses("("));
		assertEquals(0, q.longestValidParentheses("))("));
		assertEquals(0, q.longestValidParentheses("))"));
	}

	@Test
	public void test5() {
		assertEquals(6, q.longestValidParentheses("(()())"));
	}

}
