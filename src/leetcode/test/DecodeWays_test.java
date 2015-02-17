package leetcode.test;

import junit.framework.TestCase;
import leetcode.DecodeWays;

import org.junit.Test;

public class DecodeWays_test extends TestCase {
	DecodeWays q = new DecodeWays();

	@Test
	public void test1() {
		assertEquals(q.numDecodings(""), 0);
		assertEquals(q.numDecodings("0"), 0);
		assertEquals(q.numDecodings("1"), 1);
		assertEquals(q.numDecodings("9"), 1);
		assertEquals(q.numDecodings("10"), 1);
		assertEquals(q.numDecodings("11"), 2);
		assertEquals(q.numDecodings("26"), 2);
		assertEquals(q.numDecodings("27"), 1);
		assertEquals(q.numDecodings("100"), 0);
		assertEquals(q.numDecodings("101"), 1);
		assertEquals(q.numDecodings("111"), 3);
	}
}
