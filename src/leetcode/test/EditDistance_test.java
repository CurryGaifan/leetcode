package leetcode.test;

import junit.framework.TestCase;
import leetcode.EditDistance_2;

import org.junit.Test;

public class EditDistance_test extends TestCase {

	EditDistance_2 q = new EditDistance_2();

	@Test
	public void test1() {
		assertEquals(q.minDistance("", "a"), 1);
		assertEquals(q.minDistance("b", "a"), 1);
		assertEquals(q.minDistance("b", "ba"), 1);
		assertEquals(q.minDistance("bc", ""), 2);
		assertEquals(q.minDistance("bcd", "bad"), 1);
		assertEquals(q.minDistance("bcd", "*bad"), 2);
		assertEquals(q.minDistance("bcd", "*bad&"), 3);
		assertEquals(q.minDistance("bcd", "*bccd&"), 3);
		assertEquals(q.minDistance("mart", "karma"), 3);
		assertEquals(q.minDistance("sea", "ate"), 3);
		assertEquals(q.minDistance("horse", "ros"), 3);
		assertEquals(q.minDistance("teacher", "botcher"), 3);
		assertEquals(q.minDistance("abcde", "abcde"), 0);
		assertEquals(q.minDistance("distance", "daliance"), 3);
		// assertEquals(q.minDistance(
		// "pneumonoultramicroscopicsilicovolcanoconiosis",
		// "ultramicroscopically"), 13);

	}

}
