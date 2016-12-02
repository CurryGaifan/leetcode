package leetcode.test;

import leetcode.NumberofDigitOne;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by yanfeixiang on 2016/9/23.
 */
public class NumberofDigitOneTest {

    @Test
    public void test() {

        Assert.assertEquals(0, new NumberofDigitOne().countDigitOne(0));
        Assert.assertEquals(1, new NumberofDigitOne().countDigitOne(1));
        Assert.assertEquals(1, new NumberofDigitOne().countDigitOne(2));
        Assert.assertEquals(1, new NumberofDigitOne().countDigitOne(9));
        Assert.assertEquals(2, new NumberofDigitOne().countDigitOne(10));
        Assert.assertEquals(4, new NumberofDigitOne().countDigitOne(11));
        Assert.assertEquals(5, new NumberofDigitOne().countDigitOne(12));
        Assert.assertEquals(12, new NumberofDigitOne().countDigitOne(19));
        System.out.println("******");
        Assert.assertEquals(12, new NumberofDigitOne().countDigitOne(20));
        System.out.println("******");
        Assert.assertEquals(13, new NumberofDigitOne().countDigitOne(21));
        Assert.assertEquals(20, new NumberofDigitOne().countDigitOne(99));
        System.out.println("******");
        Assert.assertEquals(21, new NumberofDigitOne().countDigitOne(100));
        System.out.println("******");
        Assert.assertEquals(23, new NumberofDigitOne().countDigitOne(101));
        System.out.println("******");
        Assert.assertEquals(31, new NumberofDigitOne().countDigitOne(109));
        System.out.println("******");
        Assert.assertEquals(33, new NumberofDigitOne().countDigitOne(110));
        System.out.println("******");
        Assert.assertEquals(300, new NumberofDigitOne().countDigitOne(999));
        Assert.assertEquals(4000, +new NumberofDigitOne().countDigitOne(9999));
//        Assert.assertEquals(0, +new NumberofDigitOne().countDigitOne(1112));
    }
}
