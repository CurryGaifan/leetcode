package leetcode;

import java.util.*;

/**
 * Created by yanfeixiang on 2016/8/5.
 * <p/>
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
 * <p/>
 * Note: The input string may contain letters other than the parentheses ( and ).
 * <p/>
 * Examples:
 * "()())()" -> ["()()()", "(())()"]
 * "(a)())()" -> ["(a)()()", "(a())()"]
 * ")(" -> [""]
 */
public class RemoveInvalidParentheses {

    public List<String> removeInvalidParentheses(String s) {
        Set<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> dealedSet = new HashSet<>();
        int curLength = 0;
        s = trim(s);
        queue.add(s);
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            if (cur.length() >= curLength && isValidate(cur)) {
                if (set.isEmpty()) {
                    set.add(cur);
                    curLength = cur.length();
                } else if (cur.length() == curLength) {
                    set.add(cur);
                } else if (cur.length() > curLength) {
                    set.clear();
                    set.add(cur);
                    curLength = cur.length();
                }
            } else if (!dealedSet.contains(cur)) {
                addToQueue(cur, queue);

            }
            dealedSet.add(cur);

        }

        return new ArrayList<>(set);
    }

    private void addToQueue(String s, Queue<String> queue) {
        for (int i = 0; i < s.length(); i++) {
            String removedS = trim(remove(s, i));
//            System.out.println(removedS);
            queue.add(removedS);
        }

    }

    private boolean isValidate(String s) {
        int dif = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(')
                dif++;
            else if (c == ')')
                dif--;

            if (dif < 0)
                return false;
        }
        return dif == 0;
    }

    private String trim(String s) {

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(')
                break;
            else if (c == ')') {
                s = remove(s, i);
                i--;
            }

        }

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ')')
                break;
            else if (c == '(')
                s = remove(s, i);

        }
        return s;
    }

    private String remove(String s, int index) {
        return s.substring(0, index) + s.substring(index + 1);
    }


    public static void main(String[] args) {
        System.out.println(new RemoveInvalidParentheses().removeInvalidParentheses("()())()"));
        System.out.println(new RemoveInvalidParentheses().removeInvalidParentheses("(a)())()"));
        System.out.println(new RemoveInvalidParentheses().removeInvalidParentheses(")(").size());
        System.out.println(new RemoveInvalidParentheses().removeInvalidParentheses("()(((((((()"));
        System.out.println(new RemoveInvalidParentheses().removeInvalidParentheses("x("));
        System.out.println(new RemoveInvalidParentheses().removeInvalidParentheses("(((k()(("));
        System.out.println(new RemoveInvalidParentheses().removeInvalidParentheses("(").size());
        System.out.println(new RemoveInvalidParentheses().removeInvalidParentheses("").size());
        System.out.println(new RemoveInvalidParentheses().removeInvalidParentheses("()())()"));
//
//        new RemoveInvalidParentheses().addToQueue("(", new HashSet<String>());
    }

}
