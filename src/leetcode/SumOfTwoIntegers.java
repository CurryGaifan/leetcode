package leetcode;

/**
 * Created by yanfeixiang on 2016/8/23.
 */
public class SumOfTwoIntegers {
    public int getSum(int a, int b) {

        boolean addOne = false;
        int start = 1;
        int result = 0;
        do {
            int a_bit = a & start;
            int b_bit = b & start;
            int curBit = a_bit ^ b_bit;
            if (addOne)
                curBit ^= start;

            addOne = (a_bit == start && b_bit == start)
                    || (a_bit == start && addOne)
                    || (b_bit == start && addOne);
            result |= curBit;

            start <<= 1;
        } while (start != 0);

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new SumOfTwoIntegers().getSum(6, 5));
        System.out.println(new SumOfTwoIntegers().getSum(-6, -5));
    }
}
