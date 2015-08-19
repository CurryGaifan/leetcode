package leetcode;

/**
 * The expression string may contain open ( and closing parentheses ),
 * the plus + or minus sign -, non-negative integers and empty spaces .
 * "1 + 1" = 2
 * " 2-1 + 2 " = 3
 * "(1+(4+5+2)-3)+(6+8)" = 23
 */
public class BasicCalculator {
    public int calculate(String s) {
        int num = 0;
        int fac = 1;
        for (int i = 0; i < s.length(); ) {
            char c = s.charAt(i);

            if (c == ' ') {
                i++;
            } else if (c == '(') {
                int r_index = findRightBracket(s, i);
                num += fac * calculate(s.substring(i + 1, r_index));
                i = r_index + 1;
            } else if (c <= '9' && c >= '0') {
                int n_r_index = findNumEnd(s, i);
                num += fac * Integer.parseInt(s.substring(i, n_r_index + 1));
                i = n_r_index + 1;
            } else if (c == '+' || c == '-') {
                fac = c == '+' ? 1 : -1;
                i++;
            }
        }

        return num;
    }


    private int findNumEnd(String s, int start) {

        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c <= '9' && c >= '0') {

            } else
                return i - 1;
        }
        return s.length() - 1;
    }

    private int findRightBracket(String s, int start) {
        int leftCount = 1;
        for (int i = start + 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(')
                leftCount++;
            else if (c == ')') {
                leftCount--;
            }
            if (leftCount == 0)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new BasicCalculator().calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
