package leetcode;

/**
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces .
 * The integer division should truncate toward zero.
 * "3+2*2" = 7
 * " 3/2 " = 1
 * " 3+5 / 2 " = 5
 */
public class BasicCalculatorII {
    public int calculate(String s) {
        int num = 0;
        int fac = 1;

        for (int i = 0; i < s.length(); ) {
            int index = findNextJJ(s, i);
            num += fac * calculateCC(s.substring(i, index));
            if (index == s.length())
                break;

            fac = s.charAt(index) == '+' ? 1 : -1;
            i = index + 1;

        }


        return num;
    }

    public int calculateCC(String s) {

        int num = 1;
        int fac = 1;
        for (int i = 0; i < s.length(); ) {
            char c = s.charAt(i);

            if (c == ' ') {
                i++;

            } else if (c <= '9' && c >= '0') {
                int n_r_index = findNumEnd(s, i);
                int subNum = Integer.parseInt(s.substring(i, n_r_index + 1));

                num = fac == 1 ? num * subNum : num / subNum;
                i = n_r_index + 1;
            } else if (c == '*' || c == '/') {
                fac = c == '*' ? 1 : -1;
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

    private int findNextJJ(String s, int start) {

        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '+' || c == '-') {
                return i;
            }

        }
        return s.length();
    }

    public static void main(String[] args) {
        System.out.println(new BasicCalculatorII().calculate(" 3+5 / 2 "));
    }
}
