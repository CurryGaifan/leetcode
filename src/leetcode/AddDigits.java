package leetcode;

/**
 *
 */
public class AddDigits {
    public int addDigits(int num) {

        while (num / 10 != 0) {
            num = addDigitsOneTime(num);
        }
        return num;
    }

    public int addDigitsOneTime(int num) {
        int sum = 0;

        do {
            int a = num % 10;
            num = num / 10;
            sum += a;
        } while (num != 0);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new AddDigits().addDigits(9));
    }
}
