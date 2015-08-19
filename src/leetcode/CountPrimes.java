package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class CountPrimes {

    private static Integer[] array;

    static {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 2; i <= Integer.MAX_VALUE; i++)
            if (isPrime(i)) {
                list.add(i);
                System.out.println(i);
            }

        array = list.toArray(new Integer[list.size()]);
    }


    public int countPrimes(int n) {
        return findIndex(array, 0, array.length - 1, n);

    }

    private int findIndex(Integer[] array, int start, int end, int n) {
        if (n <= array[start])
            return start > 0 ? start - 1 : 0;
        if (n > end)
            return end;

        int middle = (start + end) / 2;

        if (n == array[middle])
            return middle - 1;
        else if (n < array[middle])
            return findIndex(array, start, middle - 1, n);
        else
            return findIndex(array, middle + 1, end, n);
    }

    private static boolean isPrime(long n) {
        if (n <= 3) {
            return n > 1;
        } else if (n % 2 == 0 || n % 3 == 0) {
            return false;
        } else {
            for (int i = 5; i * i <= n; i += 6) {
                if (n % i == 0 || n % (i + 2) == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(new CountPrimes().countPrimes(1500000));
    }
}
