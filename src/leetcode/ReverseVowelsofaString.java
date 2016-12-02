package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yanfeixiang on 2016/8/11.
 */
public class ReverseVowelsofaString {
    private static Set<Character> set = new HashSet<>();

    static {
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
    }

    public String reverseVowels(String s) {
        int i = 0;
        int j = s.length() - 1;
        char[] chars = s.toCharArray();
        while (i < j) {
            while (!set.contains(chars[i]) && i < j)
                i++;
            while (!set.contains(chars[j]) && i < j)
                j--;
            if (i < j) {
                char tmp = chars[i];
                chars[i] = chars[j];
                chars[j] = tmp;
                i++;
                j--;
            }

        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(new ReverseVowelsofaString().reverseVowels("hello"));
        System.out.println(new ReverseVowelsofaString().reverseVowels("leetcode"));
    }
}
