package leetcode.test;

import junit.framework.TestCase;
import leetcode.ExcelSheetColumnTitle;

import org.junit.Test;

public class ExcelSheetColumnTitle_test extends TestCase {
	ExcelSheetColumnTitle q = new ExcelSheetColumnTitle();

	@Test
	public void test1() {
		assertEquals(q.convertToTitle(1), "A");
		assertEquals(q.convertToTitle(27), "AA");
		assertEquals(q.convertToTitle(52), "AZ");
		assertEquals(q.convertToTitle(53), "BA");
		assertEquals(q.convertToTitle(78), "BZ");
		assertEquals(q.convertToTitle(79), "CA");
		assertEquals(q.convertToTitle(26 * 27), "ZZ");
		assertEquals(q.convertToTitle(26 * 27 + 1), "AAA");
	}

}
