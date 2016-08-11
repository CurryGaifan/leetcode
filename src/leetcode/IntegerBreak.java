package leetcode;

import java.util.HashMap;
import java.util.Map;

public class IntegerBreak {
    private static Map<Integer, Integer> map = new HashMap<>();

    public int integerBreak(int n) {

        if (n == 2)
            return 1;
        if (n == 3)
            return 2;

        return _integerBreak(n);
    }

    public int _integerBreak(int n) {

        if (n <= 3)
            return n;

        if (map.containsKey(n))
            return map.get(n);
        int max = 2 * _integerBreak(n - 2);
        max = Math.max(max, 3 * _integerBreak(n - 3));
        for (int i = 4; i <= n / 2 + 1; i++) {
            int max_i = _integerBreak(i);
            int max_j = _integerBreak(n - i);

            max = Math.max(max, max_i * max_j);

        }
        map.put(n, max);
        return max;
    }


    public static void main(String[] args) {
        System.out.println(new IntegerBreak().integerBreak(2));
        System.out.println(new IntegerBreak().integerBreak(6));
        System.out.println(new IntegerBreak().integerBreak(8));
        System.out.println(new IntegerBreak().integerBreak(10));
        System.out.println(new IntegerBreak().integerBreak(58));
    }
}
