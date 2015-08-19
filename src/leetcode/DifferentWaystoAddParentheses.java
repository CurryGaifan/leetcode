package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Example 1
 * Input: "2-1-1".
 * <p/>
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * Output: [0, 2]
 * <p/>
 * <p/>
 * Example 2
 * Input: "2*3-4*5"
 * <p/>
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 * Output: [-34, -14, -10, -10, 10]
 */
public class DifferentWaystoAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();
        boolean containsOperator = false;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '-' || c == '+' || c == '*') {
                containsOperator = true;
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));

                for (int m : left)
                    for (int n : right) {
                        int subResult = 0;
                        if (c == '-')
                            subResult = m - n;
                        else if (c == '+')
                            subResult = m + n;
                        else if (c == '*')
                            subResult = m * n;
                        result.add(subResult);
                    }
            }

        }
        if (!containsOperator)
            result.add(Integer.parseInt(input));
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new DifferentWaystoAddParentheses().diffWaysToCompute("2-1-1"));
        System.out.println(new DifferentWaystoAddParentheses().diffWaysToCompute("2*3-4*5"));
    }
}
