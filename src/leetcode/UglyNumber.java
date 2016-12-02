package leetcode;

/**
 * Created by yanfeixiang on 2016/9/14.
 */
public class UglyNumber {

    public boolean isUgly(int num) {
        if (num == 0)
            return false;

        if (num == 1)
            return true;
        int[] factors = new int[]{2, 3, 5};
        for (int factor : factors) {
            while (num % factor == 0)
                num /= factor;

            if (num == 1)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new UglyNumber().isUgly(6));
        System.out.println(new UglyNumber().isUgly(8));
        System.out.println(new UglyNumber().isUgly(14));
        System.out.println(new UglyNumber().isUgly(0));
    }
}
