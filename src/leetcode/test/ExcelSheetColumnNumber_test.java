package leetcode.test;

import junit.framework.TestCase;
import leetcode.ExcelSheetColumnNumber;

import org.junit.Test;

public class ExcelSheetColumnNumber_test extends TestCase {
	ExcelSheetColumnNumber q = new ExcelSheetColumnNumber();

	@Test
	public void test1() {
		assertEquals(q.titleToNumber("A"), 1);
		assertEquals(q.titleToNumber("AA"), 27);
		assertEquals(q.titleToNumber("AZ"), 52);
		assertEquals(q.titleToNumber("BA"), 53);
		assertEquals(q.titleToNumber("BZ"), 78);
		assertEquals(q.titleToNumber("CA"), 79);
		assertEquals(q.titleToNumber("ZZ"), 26 * 27);
		assertEquals(q.titleToNumber("AAA"), 26 * 27 + 1);
	}

}
