package leetcode.test;

import junit.framework.TestCase;
import leetcode.SearchinRotatedSortedArray;

import org.junit.Test;

public class SearchinRotatedSortedArray_test extends TestCase {

	SearchinRotatedSortedArray q = new SearchinRotatedSortedArray();

	@Test
	public void test1() {
		assertEquals(-1, q.search(new int[] { 1, 3 }, 0));
		assertEquals(0, q.search(new int[] { 1, 3 }, 1));
		assertEquals(-1, q.search(new int[] { 1, 3 }, 2));
		assertEquals(1, q.search(new int[] { 1, 3 }, 3));
		assertEquals(-1, q.search(new int[] { 1, 3 }, 4));
	}

	@Test
	public void test2() {
		assertEquals(-1, q.search(new int[] { 3, 1 }, 0));
		assertEquals(1, q.search(new int[] { 3, 1 }, 1));
		assertEquals(-1, q.search(new int[] { 3, 1 }, 2));
		assertEquals(0, q.search(new int[] { 3, 1 }, 3));
		assertEquals(-1, q.search(new int[] { 3, 1 }, 4));
	}

	@Test
	public void test3() {
		assertEquals(-1, q.search(new int[] {}, 0));

	}

	@Test
	public void test4() {
		assertEquals(0, q.search(new int[] { 4, 5, 6, 7, 8, 1, 2, 3 }, 4));
		assertEquals(3, q.search(new int[] { 4, 5, 6, 7, 8, 1, 2, 3 }, 7));
		assertEquals(4, q.search(new int[] { 4, 5, 6, 7, 8, 1, 2, 3 }, 8));
		assertEquals(5, q.search(new int[] { 4, 5, 6, 7, 8, 1, 2, 3 }, 1));
		assertEquals(7, q.search(new int[] { 4, 5, 6, 7, 8, 1, 2, 3 }, 3));
		assertEquals(-1, q.search(new int[] { 4, 5, 6, 7, 8, 1, 2, 3 }, 0));

	}

}
