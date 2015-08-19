package leetcode.test;

import junit.framework.TestCase;
import leetcode.ContainsDuplicateIII;
import leetcode.ContainsDuplicateIII_2;
import org.junit.Test;

/**
 *
 */
public class ContainsDuplicateIII_test extends TestCase {

    ContainsDuplicateIII q = new ContainsDuplicateIII();

    @Test
    public void test1() {
        assertEquals(q.containsNearbyAlmostDuplicate(new int[]{1, 1}, 1, -1), false);
        assertEquals(q.containsNearbyAlmostDuplicate(new int[]{-1, -1}, 1, 0), true);
        assertEquals(q.containsNearbyAlmostDuplicate(new int[]{1, 3, 1}, 1, 1), false);

        assertEquals(q.containsNearbyAlmostDuplicate(new int[]{4, 1, 6, 3}, 100, 1), true);
        System.out.println("--------");
        assertEquals(q.containsNearbyAlmostDuplicate(new int[]{10, 100, 11, 9}, 1, 2), true);
        assertEquals(q.containsNearbyAlmostDuplicate(new int[]{-1, 2147483647}, 1, 2147483647), false);
    }
}
