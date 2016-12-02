package leetcode;

import java.util.Arrays;

/**
 * Created by yanfeixiang on 2016/9/19.
 */
public class FindtheDifference {
    public char findTheDifference(String s, String t) {
        char[] s_a = s.toCharArray();
        char[] t_a = t.toCharArray();
        Arrays.sort(s_a);
        Arrays.sort(t_a);
        for (int i = 0; i < s_a.length; i++) {
            if (s_a[i] != t_a[i])
                return t_a[i];
        }
        return t_a[t_a.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new FindtheDifference().findTheDifference("abcd", "abcde"));
    }
}
