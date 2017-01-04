package leetcode;

public class LargestPalindromeProduct {
    public int largestPalindrome(int n) {
        long max = (long) ((Math.pow(10, n) - 1) * (Math.pow(10, n) - 1));
        max = findNext(max);
        while (max > 0) {
            if (isCanDiv(max, n)) {
//                System.out.println(n + ": " + max);
                return (int) (max % 1337);
            }

            max = findNext(max - 1);
        }
        return -1;
    }


    private long findNext(long num) {

        char[] c = String.valueOf(num).toCharArray();
        for (int i = 0; i < c.length / 2; i++) {
            if (c[i] == c[c.length - i - 1])
                continue;
            if (c[i] > c[c.length - i - 1]) {

                if (difOne(c, c.length - i - 2)) {
//                    System.out.println("num1: " + num + ", max:" + ((long) Math.pow(10, c.length - 1) - 1));
                    return (long) Math.pow(10, c.length - 1) - 1;
                }
//                System.out.println("loop1: " + new String(c));
            } else {
                c[c.length - i - 1] = c[i];
//                fillNine(c, i + 1, c.length - i - 2);
//                System.out.println("loop2: " + new String(c));
//                break;
            }

        }
//        System.out.println("num2: " + num + ", max:" + new String(c));
        return Long.valueOf(new String(c));

    }


    private boolean difOne(char[] num, int end) {
        char[] co = new char[end + 1];
        System.arraycopy(num, 0, co, 0, end + 1);
        long n = Long.valueOf(String.valueOf(co));
        long m = n;
        while (m % 10 == 0) {
            m /= 10;
        }
        if (m == 1)
            return true;


        n--;

        int length = num.length - end - 1;
        String s = String.valueOf(n).substring(0, length);
//        System.out.println("s1:" + s + ",n:" + n + ",mum:" + String.valueOf(num) + ", end:" + end);
        System.arraycopy(String.valueOf(n).toCharArray(), 0, num, 0, String.valueOf(n).length());
        System.arraycopy(new StringBuilder(s).reverse().toString().toCharArray(), 0, num, end + 1, length );
//        System.out.println("s2:" + s + ",mum:" + String.valueOf(num) + ", length:" + length);
        return false;
    }

    private boolean isCanDiv(long num, int bit) {
        double sqrt = Math.sqrt(num);

        double max = Math.pow(10, bit) - 1;

        for (long i = (long) max; i >= sqrt; i--) {
            if (num % i == 0)
                return true;
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(new LargestPalindromeProduct().largestPalindrome(1));
        System.out.println(new LargestPalindromeProduct().largestPalindrome(2));
        System.out.println(new LargestPalindromeProduct().largestPalindrome(3));
        System.out.println(new LargestPalindromeProduct().largestPalindrome(4));
        System.out.println(new LargestPalindromeProduct().largestPalindrome(5));
        System.out.println(new LargestPalindromeProduct().largestPalindrome(6));
        System.out.println(new LargestPalindromeProduct().largestPalindrome(7));
        System.out.println(new LargestPalindromeProduct().largestPalindrome(8));
    }
}
