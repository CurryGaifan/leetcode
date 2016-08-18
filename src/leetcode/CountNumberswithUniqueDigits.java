package leetcode;

/**
 * Created by gaifan on 2016/6/21.
 */
public class CountNumberswithUniqueDigits {

    public int countNumbersWithUniqueDigits(int n) {
        int sum = 0;
        int s = 1;
        int m = 0;
        for (int i = 10; m < n; i--) {
            s *= i--;
            m++;
        }
//        System.out.println(s);
        for (int i = 2; i <= n; i++) {
            int c = n - i;
            int c1 = 0;
            for (int l = 9; c1 < c; l--) {
                
                c1++;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new CountNumberswithUniqueDigits().countNumbersWithUniqueDigits(2));
    }
}
