package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<Integer>();

        while (n != 1 && !set.contains(n)) {
            set.add(n);
            int _n = n;
            n = 0;
            while (_n != 0) {
                n += Math.pow(_n % 10, 2);
                _n = _n / 10;
            }
        }
        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(new HappyNumber().isHappy(10));
    }
}
